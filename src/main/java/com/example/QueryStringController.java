package com.example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/careBears")
public class QueryStringController {

    @GetMapping("/individual")
    public String careBearMethod(@RequestParam String name, @RequestParam String power){
        return String.format("This carebear's name is %s and it's power is %s", name, power);
    }

    @GetMapping("/hashMap")
    public String careBearHashMethod(@RequestParam Map querystring) {
        return querystring.toString();
    }

}
