package com.prova.tistech.SampleScheduleAPI.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prova.tistech.api.SampleScheduleAPIApplication;
import com.prova.tistech.api.entities.Availability;
import com.prova.tistech.api.entities.Candidate;
import com.prova.tistech.api.entities.Exam;
import com.prova.tistech.api.entities.Scheduling;
import com.prova.tistech.api.security.TokenAuthenticationService;
import com.prova.tistech.api.service.bussiness.SchedulingService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SampleScheduleAPIApplication.class)
@AutoConfigureMockMvc
public class SchedulingResourceTest {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	@MockBean private SchedulingService service;
	
	@Autowired private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
	    MockitoAnnotations.initMocks(this);
	}

	@Test
	public void should_return_one_scheduling_ok() throws Exception {
		
		String token = TokenAuthenticationService.getJWTToken("admin");
		
		Scheduling entidade = createScheduling();
		
		Mockito.when(service.findAll()).thenReturn(Arrays.asList(entidade));
		
		List<Scheduling> lista = service.findAll();
		
		assertEquals(lista.size(), 1);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/schedules").header("Authorization", token).contentType(MediaType.APPLICATION_JSON_VALUE))
		 	.andDo(MockMvcResultHandlers.print())
        	.andExpect(MockMvcResultMatchers.status().isOk())
        	.andExpect(MockMvcResultMatchers.jsonPath("$.[0].candidate.id", Is.is(1)));
	}
	
	@Test
	public void should_scheduling_ok() throws Exception {
		
		String token = TokenAuthenticationService.getJWTToken("admin");
		
		Scheduling entidade = createScheduling();
		
		Mockito.when(service.insert(entidade)).thenReturn(entidade);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/schedules").header("Authorization", token).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsBytes(entidade)))
        		.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	private Scheduling createScheduling() {
		
		Candidate candidate = new Candidate();
		candidate.setId(1l);
		
		Exam exam = new Exam();
		exam.setId(1l);
		
		Availability availability = new Availability();
		availability.setId(1l);
		
		return new Scheduling(candidate, exam, availability, "");
	}
}
