package com.isi.formation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FormationBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormationBackendApplication.class, args);
    }
}
