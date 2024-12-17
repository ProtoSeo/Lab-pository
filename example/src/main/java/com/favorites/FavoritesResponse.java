package com.favorites;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FavoritesResponse {
	private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
	private String createdAt;

	protected FavoritesResponse() {
	}

	public FavoritesResponse(LocalDateTime createdAt) {
		this.createdAt = createdAt.format(DateTimeFormatter.ofPattern(PATTERN));
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
}
