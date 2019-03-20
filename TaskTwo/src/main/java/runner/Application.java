package runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// http://websystique.com/spring-boot/spring-boot-rest-api-example/

@SpringBootApplication(scanBasePackages = {"runner"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
