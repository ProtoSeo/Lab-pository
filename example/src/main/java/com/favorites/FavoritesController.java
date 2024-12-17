package com.favorites;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.common.CommonResponse;

@RestController
@RequestMapping("/api")
public class FavoritesController {

	private final FavoritesService favoritesService;

	public FavoritesController(FavoritesService favoritesService) {
		this.favoritesService = favoritesService;
	}

	@GetMapping("/user/{userId}/bookmark/stores")
	public ResponseEntity<CommonResponse<FavoritesResponse>> getFavorites(
		@PathVariable Long userId,
		@RequestParam @Nullable @DateTimeFormat(pattern = "yyyyMMddHHmmss") LocalDateTime time
	) {
		if (time == null) {
			time = LocalDateTime.now();
			System.out.println(LocalDateTime.now());
		} else {
			System.out.println(time);
		}
		FavoritesResponse response = favoritesService.hello(userId, time);
		return ResponseEntity.ok(CommonResponse.success(response));
	}
}
