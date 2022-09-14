package net.hypnozcore.hypnozcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
@EnableWebMvc
@EnableSwagger2
@EnableTransactionManagement
public class HypnozCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(HypnozCoreApplication.class, args);
    }

}
