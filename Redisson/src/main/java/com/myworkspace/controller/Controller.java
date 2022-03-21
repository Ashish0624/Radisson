package com.myworkspace.controller;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myworkspace.DataFeeding;

@RestController
public class Controller {

	private RedissonClient redisson;
	@Autowired
	DataFeeding dataFeeding;
	
	@GetMapping("/set")
	public void getSurveyType() {
		dataFeeding.mainHandler();
	}
	
	@GetMapping("/get")
	public void getSurveyTyp() {
		dataFeeding.mainHandler2();
	}
}
