package com.prova.tistech.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.tistech.api.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> { }
