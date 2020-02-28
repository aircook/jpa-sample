package kr.co.starlabs.study.jpa.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import kr.co.starlabs.study.jpa.model.type.LanguageType;
import kr.co.starlabs.study.jpa.model.type.LanguageTypeConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false, length = 500)
	private String director;

	//private String language;
	//@Enumerated(EnumType.STRING)
	@Convert(converter = LanguageTypeConverter.class)
	private LanguageType language;

	private Integer time;

	//@Temporal(TemporalType.TIMESTAMP) --> @Temporal should only be set on a java.util.Date or java.util.Calendar property 이렇게 나온다.
	//release는 reserved keyword 인지 DDL문이 오류나면서 테이블이 안만들어진다. 그래서 이름을 released로 수정
	//@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDate released;
	
	
	private LocalDateTime created;
	
	//Camel로 작성하면 데이터베이스에서는 Snake로 자동으로 바뀐다.
	private String genreType;
	

}
