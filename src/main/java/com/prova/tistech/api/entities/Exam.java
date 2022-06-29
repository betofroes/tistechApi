package com.prova.tistech.api.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.prova.tistech.api.base.entities.BasicEntitie;

@Entity
@Table(name = "exam")
public class Exam extends BasicEntitie<Exam> {
	
	@NotNull(message = "You need to enter a code")
	private String code;

	@NotBlank(message = "It is necessary to provide a name")
	private String name;

	private String description;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
