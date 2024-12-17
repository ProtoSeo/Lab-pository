package com.example.springwebsocket.handler;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChatHandler extends TextWebSocketHandler {
	private final ConcurrentMap<String, WebSocketSession> userSession = new ConcurrentHashMap<>();

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {

	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("success to connect " + session.getId());
		userSession.put(session.getId(), session);
		log.info(userSession.size() + "");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("success to disconnect " + session.getId());
		userSession.remove(session.getId());
		log.info(userSession.size() + "");
	}
}
