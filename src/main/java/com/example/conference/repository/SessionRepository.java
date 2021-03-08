package com.example.conference.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.conference.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
		
}
