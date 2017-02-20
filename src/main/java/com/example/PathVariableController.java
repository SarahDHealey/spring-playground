package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {

    @GetMapping("/carparts/{carpartId}")
    public String getCarpartId(@PathVariable String carpartId) {
        return String.format("carpartId:%d", 9);
    }
}
