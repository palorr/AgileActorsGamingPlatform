/*
 * Some description
 * goes here
 */

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgileTwoApplication {

    public static void main(String[] args) {
        new AgileTwoApplication().startup(args);
    }

    private void startup(String[] args) {
        SpringApplication.run(AgileTwoApplication.class, args);
    }
}
