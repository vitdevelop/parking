package com.vitdevelop.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by CIC on 28.04.2015.
 */
@EnableAutoConfiguration
@ComponentScan
@EntityScan("com.vitdevelop.parking.core.domain")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
