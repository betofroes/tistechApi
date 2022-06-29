package com.prova.tistech.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.tistech.api.entities.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long>{ }