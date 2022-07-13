package com.epam.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EventControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetEvent() throws Exception {
        this.mockMvc.perform(get("/event")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("Events")));
    }

    @Test
    public void shouldGetEventById() throws Exception {
        this.mockMvc.perform(get("/event/id/1")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("Classical Music")));
    }
}
