package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author vasil
 */
@SpringBootApplication
@EnableScheduling
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
