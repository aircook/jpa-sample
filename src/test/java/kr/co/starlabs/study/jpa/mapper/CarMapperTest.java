package kr.co.starlabs.study.jpa.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import kr.co.starlabs.study.jpa.model.dto.CarDto;
import kr.co.starlabs.study.jpa.model.entity.Car;

public class CarMapperTest {

	@Test
	public void shouldMapCarToDto() {
		// given
		Car car = new Car(1L, "Morris", 5, "sedan");

		// when
		//CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);
		CarMapper mapper = Mappers.getMapper(CarMapper.class);
		CarDto carDto = mapper.carToCarDto(car);
		
		// then
		assertThat(carDto).isNotNull();
		assertThat(carDto.getMake()).isEqualTo("Morris");
		assertThat(carDto.getSeatCount()).isEqualTo(5);
		assertThat(carDto.getType()).isEqualTo("sedan");
	}

}
