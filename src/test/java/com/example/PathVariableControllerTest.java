package com.example;

import com.example.controller.PathVariableController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PathVariableController.class)

public class PathVariableControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getIndividualParams() throws Exception {
        int carpartId = 9;
        int sectionId = 4;
        RequestBuilder request = MockMvcRequestBuilders.get(String.format("/carparts/%d/%d", carpartId, sectionId));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("carpartId:9; sectionId:4"));
    }
    @Test
    public void getParamsAsMap() throws Exception {
        int taskId = 34;
        int commentId = 6;
        RequestBuilder request = MockMvcRequestBuilders.get(String.format("/tasks/%d/commentsAsMap/%d", taskId, commentId));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{taskId=34, commentId=6}"));
    }
    @Test
    public void getParamsAsCustomObject() throws Exception {
        int taskId = 34;
        int commentId = 6;
        RequestBuilder request = MockMvcRequestBuilders.get(String.format("/tasks/%d/commentsAsObject/%d", taskId, commentId));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("taskId is 34; commentId is 6"));

    }

}
