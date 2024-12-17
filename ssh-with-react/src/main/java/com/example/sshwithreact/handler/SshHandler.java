package com.example.sshwithreact.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.example.sshwithreact.service.SshService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SshHandler extends TextWebSocketHandler {
	private final SshService sshService;


}
