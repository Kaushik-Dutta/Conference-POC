package com.example.conference.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.conference.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long>{

}
