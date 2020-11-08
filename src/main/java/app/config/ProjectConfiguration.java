package app.config;

import app.model.user.UserModel;
import app.repository.UserRepository;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 *
 * @author Vasiliy.Andricov
 */
@Slf4j
@Configuration
public class ProjectConfiguration {

    @Autowired
    UserRepository userRepository;

    /**
     *
     */
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws FileNotFoundException, IOException {
        log.info("App started up");
        genTestData();
    }

    /**
     *
     */
    private void genTestData() throws FileNotFoundException, IOException {
        List<byte[]> images = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            File file = new File(getClass().getResource("/static/img/" + (i + 1) + ".jpg").getFile());
            byte[] image = Files.readAllBytes(file.toPath());
            images.add(image);
        }

        // Генерация пользователя
        List<UserModel> userList = Arrays.asList(new UserModel(1L, "test", "test@mail.ru", "123", "123"));
        userRepository.saveAll(userList);

    }
}
