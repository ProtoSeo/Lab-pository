package com.example.dockerclient.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/v1/docker-images")
@RequiredArgsConstructor
public class DockerImageController {
	public final DockerClient dockerClient;

	@GetMapping("/")
	public ResponseEntity<List<Image>> getDockerImageList() {
		List<Image> images = dockerClient.listImagesCmd().exec();
		return ResponseEntity.ok(images);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Image>> getAllDockerImageList() {
		List<Image> images = dockerClient.listImagesCmd().withShowAll(true).exec();
		return ResponseEntity.ok(images);
	}
}
