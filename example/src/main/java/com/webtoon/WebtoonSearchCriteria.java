package com.webtoon;

import java.time.LocalDate;

public class WebtoonSearchCriteria {
	private LocalDate date;
	private Genre genre;
	private Boolean finished;

	protected WebtoonSearchCriteria() {/*no-op*/}

	public WebtoonSearchCriteria(LocalDate date, Genre genre, Boolean finished) {
		this.date = date;
		this.genre = genre;
		this.finished = finished;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}
}
