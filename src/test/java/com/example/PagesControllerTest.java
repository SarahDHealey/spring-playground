package com.example;

import com.example.controller.PagesController;
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
@WebMvcTest(PagesController.class)
public class PagesControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testHomePage() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("hello Sarah and Ji!!!!! Love, Java"));

    }
    @Test
    public void testPatch() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.patch("/revise");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("hello Sarah and Ji!!!!! Love, endpoints and tests"));

    }
    @Test
    public void testDelete() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/goodbye");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(""));

    }
}
