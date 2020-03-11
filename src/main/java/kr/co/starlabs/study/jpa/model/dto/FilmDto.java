package kr.co.starlabs.study.jpa.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import kr.co.starlabs.study.jpa.model.type.LanguageType;
import lombok.Data;

//@Getter
public class FilmDto {

	@Data
	public static class Read implements Serializable {

		private Long id;

		private String title;

		private Long directorId;

		//private String language;
		private LanguageType language;

		private Integer time;

		private LocalDate released;

		private LocalDateTime created;

	}

	@Data
	public static class Insert {

		private String title;

		private Long directorId;

		//private String language;
		private LanguageType language;

		private Integer time;
		
		private LocalDate released;

	}

	@Data
	public static class Update {

		private Long id;

		private String title;

		private Long directorId;

		//private String language;
		private LanguageType language;

		private Integer time;
		
		private LocalDate released;
	}

	@Data
	public static class Delete {

		private Long id;

	}

}
