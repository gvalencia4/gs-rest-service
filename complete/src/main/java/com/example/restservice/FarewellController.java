package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class FarewellController {

    private static final String template = "Farewell, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/farewell")
    public Farewell farewell(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Farewell(counter.incrementAndGet(), String.format(template, name));
    }
}
