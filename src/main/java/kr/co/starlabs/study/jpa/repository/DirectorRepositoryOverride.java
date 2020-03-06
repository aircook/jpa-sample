package kr.co.starlabs.study.jpa.repository;

import java.util.List;

import com.querydsl.core.Tuple;

import kr.co.starlabs.study.jpa.model.dto.DirectorDto.Read;

public interface DirectorRepositoryOverride {

	List<Read> findAllDirectorWithFilmCount();
	
}
