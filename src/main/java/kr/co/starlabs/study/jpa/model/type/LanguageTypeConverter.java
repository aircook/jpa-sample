package kr.co.starlabs.study.jpa.model.type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import lombok.extern.slf4j.Slf4j;

@Converter(autoApply = true)
@Slf4j
public class LanguageTypeConverter implements AttributeConverter<LanguageType, String> {

	//KOREAN --> 한국어
	@Override
	public String convertToDatabaseColumn(LanguageType attribute) {
		
		log.debug("[{}] To Database 시작", attribute);
		
		return attribute.getTitle();
	}

	@Override
	//한국어 --> KOREAN
	public LanguageType convertToEntityAttribute(String dbData) {
		
		log.debug("[{}] To Entity 시작", dbData);
		
		return LanguageType.ofLanguageType(dbData);
	}

}
