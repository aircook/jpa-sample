package kr.co.starlabs.study.jpa.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import kr.co.starlabs.study.jpa.model.type.LanguageType;
import lombok.AllArgsConstructor;
import lombok.Data;

public class DirectorDto {

	@Data
	//@AllArgsConstructor --> java.lang.InstantiationException: kr.co.starlabs.study.jpa.model.dto.DirectorDto$Read 사용하면 Exception 발생, 기본생성자가 없기 때문이지.. 
	public static class Read {

		private Long id;
		
		private String name;

		private LocalDate birthDate;
		
		private LocalDateTime created;
		
		private Long directorCount;

	}

}
