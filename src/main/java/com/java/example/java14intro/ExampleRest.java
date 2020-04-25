package com.java.example.java14intro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * rest controller with one example rest api
 */
@RestController
public class ExampleRest {

    @GetMapping("/test")
    public static String test() {
        return "it works!";
    }

}
