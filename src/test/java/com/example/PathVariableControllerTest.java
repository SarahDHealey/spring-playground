package com.example;

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
    public void carPartFinder() throws Exception {
        int carpartId = 9;
        RequestBuilder request = MockMvcRequestBuilders.get("/carparts/%d", carpartId);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("carpartId:9"));
    }

}
