package com.prova.tistech.api.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.prova.tistech.api.base.entities.BasicEntitie;

@Entity
@Table(name = "room")
public class Room extends BasicEntitie<Room> {
	
	@NotNull(message = "You need to enter a code")
	private String code;

	private String description;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
