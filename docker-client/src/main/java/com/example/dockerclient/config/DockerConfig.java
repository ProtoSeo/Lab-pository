package com.example.dockerclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

@Configuration
public class DockerConfig {
	@Bean
	public DockerClient dockerClient() {
		return DockerClientBuilder.getInstance().build();
	}

	@Bean
	public DockerClientConfig dockerClientConfig() {
		return DefaultDockerClientConfig.createDefaultConfigBuilder().build();
	}
}