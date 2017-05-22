package com.crgroup;

import com.crgroup.config.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages = "com.crgroup")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
