package com.example.demo.controller;


import com.example.demo.property.ApplicationProperty;
import com.example.demo.property.DeveloperProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
public class PropertyController {

	private final ApplicationProperty applicationProperty;

	private final DeveloperProperty developerProperty;

	@Autowired
	PropertyController(ApplicationProperty applicationProperty, DeveloperProperty developerProperty) {
		this.applicationProperty = applicationProperty;
		this.developerProperty   = developerProperty;
	}

	@GetMapping("/property")
	public String property() {
		HashMap<String, String> result = new HashMap<String, String>();
		result.put("applicationProperty", this.applicationProperty.toString());
		result.put("developerProperty",   this.developerProperty.toString());
		return result.toString();
	}
}
