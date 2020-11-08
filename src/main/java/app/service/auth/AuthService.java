package app.service.auth;

import app.bean.AuthContext;
import app.credentionls.CredentionalInterface;
import app.credentionls.CredentionalType;
import app.credentionls.PasswordCredentional;
import app.logging.EventType;
import app.logging.LoggerBuilder;
import app.model.user.UserModel;
import app.repository.LogRepository;
import app.repository.UserRepository;
import java.util.AbstractMap;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

/**
 *
 * @author vasil
 */
@Service
@Slf4j
public class AuthService {
    
    @Autowired
    HttpServletRequest request;
    
    @Autowired
    AuthContext authContext;
    
    @Autowired
    CacheManager cacheManager;
    
    @Autowired
    LogRepository logRepository;
    
    @Autowired
    UserRepository userRepository;
    
    public boolean sessionValidate(String username) {
        boolean result = false;
        UserModel user = userRepository.findByUsername(username);
        if (user != null) {
            authContext.getSessionContext().setUserId(String.valueOf(user.getId()));
        }
        
        if (authContext.getSessionId() != null) {
            result = true;
        }
        log.info("result = {}", result);
        return result;
    }

    /**
     * Устанавливает контекст из параметров запроса и cooki
     *
     * @param redirectUri
     */
    public void setContext(String redirectUri) {
        cacheManager.getCacheNames().forEach(System.out::println);
        try {
            ValueWrapper session = cacheManager.getCache("session").get(authContext.getSessionId());
            if (session == null) {
                authContext.setSessionId(UUID.randomUUID().toString());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        
        authContext.setIpAddress(request.getRemoteAddr());
        authContext.setUserAgent(request.getHeader("User-Agent"));
        authContext.setRedirectUri(redirectUri);
    }
    
    public boolean isValidate(String username, String password) {
        boolean result;
        CredentionalInterface credentionals = new PasswordCredentional(CredentionalType.PASSWORD);
        result = credentionals.isValid(password, "123");
        LoggerBuilder logger = new LoggerBuilder()
                .setDate(new Date())
                .setSeesionId(authContext.getSessionId())
                .setJsonDetails(Stream.of(
                        new AbstractMap.SimpleEntry<>("username", username),
                        new AbstractMap.SimpleEntry<>("agent", authContext.getUserAgent()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
                .setUserId(authContext.getSessionContext().getUserId());
        if (result) {
            logger.setType(EventType.LOGIN);
        } else {
            logger.setType(EventType.LOGIN_ERROR);
            logger.setErrror("invalid user credentionals");
        }
        logRepository.save(logger.getLogItem());
        return result;
    }
}
