package kr.co.starlabs.study.jpa.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

//@Getter
public class FilmDto {

	@Data
	public static class Read {

		private Long id;

		private String title;

		private String director;

		private String language;

		private Integer time;

		//@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
		private LocalDate released;

		private LocalDateTime created;

	}

	@Data
	public static class Insert {

		private String title;

		private String director;

		private String language;

		private Integer time;
		
		private LocalDate released;

	}

	@Data
	public static class Update {

		private Long id;

		private String title;

		private String director;

		private String language;

		private Integer time;
		
		private LocalDate released;
	}

	@Data
	public static class Delete {

		private Long id;

	}

}