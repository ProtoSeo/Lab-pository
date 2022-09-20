package com.example.dockerclient.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.InspectImageResponse;
import com.github.dockerjava.api.command.PullImageResultCallback;
import com.github.dockerjava.api.model.Image;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/docker-images")
@RequiredArgsConstructor
public class DockerImageController {
	public final DockerClient dockerClient;

	@GetMapping("")
	public ResponseEntity<List<Image>> getDockerImageList() {
		List<Image> images = dockerClient.listImagesCmd().exec();
		return ResponseEntity.ok(images);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Image>> getAllDockerImageList() {
		List<Image> images = dockerClient.listImagesCmd().withShowAll(true).exec();
		return ResponseEntity.ok(images);
	}

	@GetMapping("/inspect")
	public ResponseEntity<InspectImageResponse> inspectDockerImage(@RequestParam String imageId) {
		InspectImageResponse response = dockerClient.inspectImageCmd(imageId).exec();
		return ResponseEntity.ok(response);
	}

	@PostMapping("")
	public ResponseEntity<Boolean> pullDockerImage(
		@RequestParam String repository,
		@RequestParam(defaultValue = "latest") String tag) throws InterruptedException {
		boolean isSuccess = dockerClient.pullImageCmd(repository)
			.withTag(tag)
			.exec(new PullImageResultCallback())
			.awaitCompletion(30, TimeUnit.SECONDS);

		return ResponseEntity.ok(isSuccess);
	}

}
