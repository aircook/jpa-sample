package kr.co.starlabs.study.jpa.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
public class CarDto {

	private Long id;

	private String make;

	private Integer seatCount;

	private String type;
	
}
