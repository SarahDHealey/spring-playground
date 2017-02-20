package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QueryStringController.class)

public class QueryStringControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testIndividualQueryEndpoint() throws Exception {
        RequestBuilder request = get("/careBears/individual?name=sleepyBear&power=sleep");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("This carebear's name is sleepyBear and it's power is sleep"));
    }

    @Test
    public void testQueryBearMap() throws Exception {
        RequestBuilder request = get("/careBears/hashMap?name=sleepyBear&power=sleep");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{name=sleepyBear, power=sleep}"));
    }

    @Test
    public void testQueryObjects() throws Exception {
        RequestBuilder request = get("/careBears/photos?sortBy=date&owner=Chloe");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("sortBy is date; owner is Chloe"));
    }

}

