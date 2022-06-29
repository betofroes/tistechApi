package com.prova.tistech.api.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prova.tistech.api.base.entities.BasicEntitie;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "candidate")
public class Candidate extends BasicEntitie<Candidate> {
	
	@NotNull(message = "You need to enter a code")
	private Integer code;

	@NotBlank(message = "It is necessary to provide a name")
	private String name;
	
	@NotBlank(message = "An identification number is required")
	@Column(name = "tax_number")
	private String taxNumber;
	
	@NotNull(message = "You must provide a date of birth")
	@Column(name = "birth_date")
	@JsonFormat(pattern = "yyyy/MM/dd")
	@ApiModelProperty(example = "yyyy/MM/dd")
	private LocalDate birthDate;
	
	private String logradouro;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}