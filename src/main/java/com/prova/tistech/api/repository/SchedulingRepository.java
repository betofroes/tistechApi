package com.prova.tistech.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prova.tistech.api.entities.Availability;
import com.prova.tistech.api.entities.Scheduling;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Long>{
	
	@Query("SELECT e FROM Scheduling e WHERE e.availability = ?1")
	public Scheduling findBy(Availability availability);

	@Query("SELECT e FROM Scheduling e WHERE e.candidate.taxNumber = ?1")
	public List<Scheduling> findByTaxNumber(String taxNumber);
}