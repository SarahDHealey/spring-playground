package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.TaskIds;

import java.util.Map;

@RestController
public class PathVariableController {

    @GetMapping("/carparts/{carpartId}/{sectionId}")
    public String getIndividualParams(@PathVariable int carpartId, @PathVariable("sectionId") int sId) {
        return String.format("carpartId:%d; sectionId:%d", carpartId, sId);
    }
    @GetMapping("/tasks/{taskId}/commentsAsMap/{commentId}")
    public String getCommentsForTaskMap(@PathVariable Map pathVariables) {
        return pathVariables.toString();
    }

    @GetMapping("/tasks/{taskId}/commentsAsObject/{commentId}")
    public String getCommentsForTaskObject(TaskIds ids) {
        return String.format("taskId is %d; commentId is %s", ids.getTaskId(), ids.getCommentId());
    }

}
