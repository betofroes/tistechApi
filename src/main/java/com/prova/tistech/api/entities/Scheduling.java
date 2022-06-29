package com.prova.tistech.api.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.prova.tistech.api.base.entities.BasicEntitie;

@Entity
@Table(name = "scheduling")
public class Scheduling extends BasicEntitie<Scheduling>{

	private static final String IT_IS_NECESSARY_TO_INFORM_A_AVAILABILITY = "It is necessary to inform a availability";

	private static final String IT_IS_NECESSARY_TO_INFORM_A_EXAM = "It is necessary to inform a exam";

	private static final String IT_IS_NECESSARY_TO_INFORM_A_CANDIDATE = "It is necessary to inform a candidate";

	@NotNull(message = IT_IS_NECESSARY_TO_INFORM_A_CANDIDATE)
	@ManyToOne
	@JoinColumn(name="id_candidate", nullable = false)
	private Candidate candidate;
	
	@NotNull(message = IT_IS_NECESSARY_TO_INFORM_A_EXAM)
	@ManyToOne
	@JoinColumn(name="id_exam", nullable = false)
	private Exam exam;
	
	@NotNull(message = IT_IS_NECESSARY_TO_INFORM_A_AVAILABILITY)
	@ManyToOne
	@JoinColumn(name="id_availability", nullable = false)
	private Availability availability;
	
	private String description;

	public Scheduling() {
	}

	public Scheduling(@NotNull(message = IT_IS_NECESSARY_TO_INFORM_A_CANDIDATE) Candidate candidate,
			@NotNull(message = IT_IS_NECESSARY_TO_INFORM_A_EXAM) Exam exam,
			@NotNull(message = IT_IS_NECESSARY_TO_INFORM_A_AVAILABILITY) Availability availability,
			String description) {
		super();
		this.candidate = candidate;
		this.exam = exam;
		this.availability = availability;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
}
