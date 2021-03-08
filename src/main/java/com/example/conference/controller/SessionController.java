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

import com.example.conference.models.Session;
import com.example.conference.repository.SessionRepository;

@RestController
@RequestMapping("/api/session")
public class SessionController {
	
	@Autowired
	SessionRepository sessionrepository;
	
	@GetMapping
	public List<Session> getSessionList()
	{
		return sessionrepository.findAll();
	}
	
	@GetMapping("{id}")
	public Session getSessionById(@PathVariable Long id)
	{
		return sessionrepository.getOne(id);
	}
	
	@PostMapping
	public Session insertRecord(@RequestBody final Session session)
	{
		return sessionrepository.saveAndFlush(session);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public void sessionDelete(@PathVariable Long id)
	{
		sessionrepository.deleteById(id);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public Session sessionUpdate(@RequestBody Session session, @PathVariable Long id)
	{
		Session existingSession = sessionrepository.getOne(id);
		BeanUtils.copyProperties(session, existingSession,"session_id");
		return sessionrepository.saveAndFlush(existingSession);
	}
	
	
	
}
