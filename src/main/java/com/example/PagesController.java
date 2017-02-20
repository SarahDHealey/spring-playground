package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class PagesController {

    @GetMapping("/hello")
    public String hello(){
        return "hello Sarah and Ji!!!!! Love, Java";
    }

    @PatchMapping ("/revise")
    public String revise(){
        return "hello Sarah and Ji!!!!! Love, endpoints and tests";
    }

    @DeleteMapping("/goodbye")
    public void goodbye() {
    }
}
