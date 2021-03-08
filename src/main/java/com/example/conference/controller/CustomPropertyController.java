package com.example.conference.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomPropertyController {

	@Value("${app.version}") //gives the custom property value
	private String appVersion;
	
	@GetMapping("/")
	public Map<String, String> propertyValue()
	{
		Map<String, String> m =new HashMap<String,String>();
		m.put("app-Version", appVersion);
		return m;
	}
	
	
	
	
}
