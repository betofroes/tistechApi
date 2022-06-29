package com.prova.tistech.SampleScheduleAPI.resource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.prova.tistech.api.SampleScheduleAPIApplication;
import com.prova.tistech.api.security.TokenAuthenticationService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SampleScheduleAPIApplication.class)
@AutoConfigureMockMvc
public class TokenAuthenticationServiceTest {


	@Autowired
    private MockMvc mvc;

    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/schedules")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void shouldGenerateAuthToken() throws Exception {
        String token = TokenAuthenticationService.getJWTToken("admin");

        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders.get("/schedules").header("Authorization", token)).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
