package com.prova.tistech.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.tistech.api.entities.Availability;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long>{ }
