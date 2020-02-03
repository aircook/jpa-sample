package kr.co.starlabs.study.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import kr.co.starlabs.study.jpa.model.dto.CarDto;
import kr.co.starlabs.study.jpa.model.entity.Car;

@Mapper
public interface CarMapper {

    //CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);
	
}
