package com.alsry.testcodepractice.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TestcodepracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestcodepracticeApplication.class, args);
    }

}
