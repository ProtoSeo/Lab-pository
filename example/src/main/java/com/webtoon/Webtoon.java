package com.webtoon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Webtoon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long webtoonId;


}
