package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PathVariableController {

    @GetMapping("/carparts/{carpartId}/{sectionId}")
    public String getIndividualParams(@PathVariable int carpartId, @PathVariable("sectionId") int sId) {
        return String.format("carpartId:%d; sectionId:%d", carpartId, sId);
    }
    @GetMapping("/tasks/{taskId}/comments/{commentId}")
    public String getCommentsForTask(@PathVariable Map pathVariables) {
        return pathVariables.toString();
    }

}
