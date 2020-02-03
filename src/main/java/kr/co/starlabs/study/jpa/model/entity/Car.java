package kr.co.starlabs.study.jpa.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
//@NoArgsConstructor
public class Car {

	@Id
	@GeneratedValue
	private Long id;

	private String make;

	private Integer numberOfSeats;

	private String type;
	
}
