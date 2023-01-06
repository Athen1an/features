package ru.athena.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.athena.logging.util.LoggingUtil;

@Slf4j
@SpringBootApplication
public class ValidationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ValidationApplication.class);
        LoggingUtil.logApplicationStartup(run.getEnvironment(), log);
    }
}
