package com.prova.tistech.SampleScheduleAPI.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.prova.tistech.api.SampleScheduleAPIApplication;
import com.prova.tistech.api.entities.Availability;
import com.prova.tistech.api.entities.Candidate;
import com.prova.tistech.api.entities.Exam;
import com.prova.tistech.api.entities.Room;
import com.prova.tistech.api.entities.Scheduling;
import com.prova.tistech.api.exception.ConsistencyFailureException;
import com.prova.tistech.api.repository.AvailabilityRepository;
import com.prova.tistech.api.repository.CandidateRepository;
import com.prova.tistech.api.repository.ExamRepository;
import com.prova.tistech.api.repository.RoomRepository;
import com.prova.tistech.api.repository.SchedulingRepository;
import com.prova.tistech.api.service.bussiness.SchedulingService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SampleScheduleAPIApplication.class)
public class SchedulingServiceTest {
	
	@Autowired private SchedulingRepository repository;
	@Autowired private CandidateRepository candidateRepository;
	@Autowired private ExamRepository examRepository;
	@Autowired private AvailabilityRepository availabilityRepository;
	@Autowired private RoomRepository roomRepository;

	@Autowired private SchedulingService service;
	
	private Availability createDadosTest() {
		
		Candidate candidate = new Candidate();
		candidate.setBirthDate(LocalDate.of(1980, 1, 1));
		candidate.setCode(1);
		candidate.setLogradouro("rua teste 1");
		candidate.setName("Teste 1");
		candidate.setTaxNumber("123456");
		candidate = candidateRepository.save(candidate);
		
		Exam exam = new Exam();
		exam.setCode("1");
		exam.setDescription("Exam 1");
		exam.setName("Exam 1");
		exam = examRepository.save(exam);
		
		Room room = new Room();
		room.setCode("1");
		room.setDescription("Room 1");
		room = roomRepository.save(room);
		
		Availability availability = new Availability();
		availability.setData(LocalDate.of(2022, 6, 30));
		availability.setDescription("Availability 1");
		availability.setRoom(room);
		availability = availabilityRepository.save(availability);
		
		repository.save(new Scheduling(candidate, exam, availability, ""));
		
		return availability;
	}
	
	
	@Test
	public void should_throw_exception_when_availability_is_already_in_used() throws Exception {
		
		Availability availability = createDadosTest();
		
		Scheduling entidadeConcorrente = createSchedulingConcorrent(availability);
		
		Exception exception = assertThrows(ConsistencyFailureException.class, () -> service.insert(entidadeConcorrente));
		
		String expectedMessage = "Schedule Error because Availability is already in used";
		
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
		
	}
	
	private Scheduling createSchedulingConcorrent(Availability availability) {
		
		Candidate candidate = new Candidate();
		candidate.setBirthDate(LocalDate.of(1982, 2, 2));
		candidate.setCode(2);
		candidate.setLogradouro("rua teste 2");
		candidate.setName("Teste 2");
		candidate.setTaxNumber("654321");
		candidate = candidateRepository.save(candidate);
		
		Exam exam = new Exam();
		exam.setCode("2");
		exam.setDescription("Exam 2");
		exam.setName("Exam 2");
		exam = examRepository.save(exam);
		
		return new Scheduling(candidate, exam, availability, "");
	}

}
