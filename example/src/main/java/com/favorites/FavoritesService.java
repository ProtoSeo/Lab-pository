package com.favorites;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FavoritesService {
	@Transactional
	public FavoritesResponse hello(Long userId, LocalDateTime time) {
		return new FavoritesResponse(time);
	}
}
