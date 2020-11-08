package app.config;

import app.bean.AuthContext;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author vasil
 */
@org.springframework.context.annotation.Configuration
@EnableCaching
public class Configuration {

    @Bean
    @SessionScope
    public AuthContext authContextScopedBean() {
        return new AuthContext();
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("session");
    }
}
