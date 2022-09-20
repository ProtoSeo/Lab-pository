package com.example.dockerclient.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/docker-containers")
@RequiredArgsConstructor
public class DockerContainerController {
	private final DockerClient dockerClient;

	// Container List
	@GetMapping("")
	public ResponseEntity<List<Container>> getContainerList() {
		List<Container> containerList = dockerClient
			.listContainersCmd()
			.exec();
		return ResponseEntity.ok(containerList);
	}

	@GetMapping("/running")
	public ResponseEntity<List<Container>> getRunningContainerList() {
		List<Container> containerList = dockerClient
			.listContainersCmd()
			.withShowAll(true)
			.withShowSize(true)
			.withStatusFilter(Collections.singleton("container_status"))
			.exec();
		return ResponseEntity.ok(containerList);
	}

	// create container
	@PostMapping("")
	public ResponseEntity<CreateContainerResponse> createContainer(
		@RequestParam String image,
		@RequestParam(defaultValue = "latest") String tag) {
		CreateContainerResponse response = dockerClient.createContainerCmd(image + tag).exec();

		return ResponseEntity.ok(response);
	}

	@PostMapping("/with")
	public ResponseEntity<CreateContainerResponse> createContainerWithParam(
		@RequestParam String image,
		@RequestParam(defaultValue = "latest") String tag) {
		ExposedPort port = ExposedPort.tcp(22);

		CreateContainerResponse response = dockerClient.createContainerCmd(image + ":" + tag)
			.withCmd("/bin/bash")
			.withHostConfig(HostConfig.newHostConfig().withPortBindings(PortBinding.parse("31000:22")))
			.withExposedPorts(port)
			.withTty(true)
			.withName(image)
			.exec();

		dockerClient.startContainerCmd(response.getId()).exec();
		return ResponseEntity.ok(response);
	}
}
