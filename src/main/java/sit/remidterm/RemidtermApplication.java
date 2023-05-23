package sit.remidterm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import sit.remidterm.properties.FileStorageProperties;

@SpringBootApplication

@EnableConfigurationProperties(
        FileStorageProperties.class)
public class RemidtermApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemidtermApplication.class, args);
    }

}
