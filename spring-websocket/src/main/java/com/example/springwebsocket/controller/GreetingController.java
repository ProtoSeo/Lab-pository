package com.example.springwebsocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GreetingController {

	@MessageMapping("/greeting")
	@SendTo("/topic/greeting")
	public String handle(String greeting) {
		String result = "[" + getTimestamp() + ": " + greeting;
		log.info(result);
		return result;
	}

	private String getTimestamp() {
		return String.valueOf(System.currentTimeMillis());
	}
}
