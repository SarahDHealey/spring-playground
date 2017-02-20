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

    public static class PhotoInfo {
        private String sortBy;
        private String owner;

        public String getSortBy() {
            return sortBy;
        }

        public void setSortBy(String sortBy) {
            this.sortBy = sortBy;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }
    }

    @GetMapping("/photos")
    public String careBearPhotos(PhotoInfo photoInfo) {
        return String.format("sortBy is %s; owner is %s", photoInfo.getSortBy(), photoInfo.getOwner());
    }

}


