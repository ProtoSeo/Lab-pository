package com.example.sshwithreact.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ssh")
public class SshController {

	@GetMapping
	public ResponseEntity<String> sshConnection() {
		return ResponseEntity.ok("hello");
	}
}
