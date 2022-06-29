package com.prova.tistech.api.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prova.tistech.api.base.entities.BasicEntitie;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "availability")
public class Availability extends BasicEntitie<Availability> {

	private String description;
	
	@NotNull(message = "It is necessary to inform a room")
	@ManyToOne
	@JoinColumn(name="id_room")
	private Room room;
	
	@NotNull(message = "It is necessary to provide a date")
	@JsonFormat(pattern = "yyyy/MM/dd")
	@ApiModelProperty(example = "yyyy/MM/dd")
	private LocalDate data;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
