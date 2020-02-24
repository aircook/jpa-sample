package kr.co.starlabs.study.jpa.model.type;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum LanguageType {

	KOREAN("한국어"), ENGLISH("영어");

	private String title;

	LanguageType(String title) {
		this.title = title;
	}

	public static LanguageType ofLanguageType(String title) {

		return Arrays.stream(LanguageType.values())
				.filter(e -> e.getTitle().equals(title))
				.findAny()
				.orElseThrow(() -> new RuntimeException(String.format("[%s]에 해당하는 LanguageType이 존재하지 않습니다.", title)));

	}

}
