package app.conntroller;

import app.bean.AuthContext;
import app.service.auth.AuthService;
import java.io.IOException;
import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vasil
 */
@Controller
@Slf4j
public class PageController {

    @Autowired
    AuthContext authContext;

    @Autowired
    HttpServletResponse response;

    @Autowired
    AuthService authService;

    @GetMapping("/auth")
    public String auth(@RequestParam(name = "redirect_uri", required = true) String redirectUri,
            @RequestParam(name = "grant_type", required = true) String grantType) throws IOException {
        authService.setContext(redirectUri);

        return "auth";
    }

    @PostMapping("/authenticate")
    public ResponseEntity authorize(@RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password) {
        log.info("context = {}", authContext);

        if (authService.sessionValidate(username)) {
            URI location = URI.create(authContext.getRedirectUri());
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(location);
            return new ResponseEntity(headers, HttpStatus.FOUND);
        } else {
            log.info("Проверка имени и пароля пользователя");
            if (authService.isValidate(username, password)) {
                URI location = URI.create(authContext.getRedirectUri());
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(location);
                return new ResponseEntity(headers, HttpStatus.FOUND);
            } else {
                return new ResponseEntity(HttpStatus.OK);
            }
        }

    }

    @ModelAttribute("title")
    public String titleMessage() {
        return "Авторизация";
    }

}
