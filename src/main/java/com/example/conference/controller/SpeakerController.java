package com.example.conference.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.conference.models.Speaker;
import com.example.conference.repository.SpeakerRepository;

@RestController
@RequestMapping("/api/speaker")
public class SpeakerController {

	@Autowired
	SpeakerRepository speakerRepository;
	
	@GetMapping
	public List<Speaker> getSpeakerList()
	{
		return speakerRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Speaker getSpeakerById(@PathVariable Long id)
	{
		return speakerRepository.getOne(id);
	}
	
	@PostMapping
	public Speaker insertSpeaker(@RequestBody Speaker speaker)
	{
		return speakerRepository.saveAndFlush(speaker);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public void deleteSpeaker(@PathVariable Long id)
	{
		speakerRepository.deleteById(id);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public Speaker updateSpeaker(@PathVariable Long id, @RequestBody Speaker speaker)
	{
		Speaker existingSpeaker=speakerRepository.getOne(id);
		BeanUtils.copyProperties(speaker, existingSpeaker, "session_id");
		return speakerRepository.saveAndFlush(existingSpeaker);
	}
}
