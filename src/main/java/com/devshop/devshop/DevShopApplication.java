package com.devshop.devshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class DevShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevShopApplication.class, args);
    }

}
