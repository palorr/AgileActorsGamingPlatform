package com.agile.controllers;


import com.agile.models.Greeting;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting/{name}")
    public Greeting greeting(@PathVariable(value="name") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
