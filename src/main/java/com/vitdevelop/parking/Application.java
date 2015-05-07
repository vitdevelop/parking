package com.vitdevelop.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by CIC on 28.04.2015.
 */
@EnableAutoConfiguration
@ComponentScan
@EntityScan("com.vitdevelop.parking.core.domain")
@EnableJpaRepositories("com.vitdevelop.parking.core.repository.")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
