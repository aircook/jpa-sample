package kr.co.starlabs.study.jpa.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	private String director;

	private String language;

	private Integer time;

	//@Temporal(TemporalType.TIMESTAMP) --> @Temporal should only be set on a java.util.Date or java.util.Calendar property 이렇게 나온다.
	//release는 reserved keyword 인지 DDL문이 오류나면서 테이블이 안만들어진다. 그래서 이름을 released로 수정
	private LocalDate released;
	
	private LocalDateTime created;
	

}
