package kr.co.starlabs.study.jpa.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

//Camel로 작성하면 데이터베이스에서는 Snake로 자동으로 바뀐다. --> create table film_director
@Entity
@Data
public class FilmDirector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	//Camel로 작성하면 데이터베이스에서는 Snake로 자동으로 바뀐다. --> birth_date date,
	private LocalDate birthDate;
	
	private LocalDateTime created;
	
}
