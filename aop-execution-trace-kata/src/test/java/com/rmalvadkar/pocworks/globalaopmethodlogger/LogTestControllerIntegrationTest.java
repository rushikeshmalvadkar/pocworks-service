package com.rmalvadkar.pocworks.globalaopmethodlogger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class LogTestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCheckLogEndpoint() throws Exception {
        mockMvc.perform(get("/api/logTest/check"))
                .andExpect(status().isOk())
                .andExpect(content().string("rushikesh"));
    }

}