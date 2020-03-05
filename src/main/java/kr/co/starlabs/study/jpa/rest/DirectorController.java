package kr.co.starlabs.study.jpa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.Tuple;

import kr.co.starlabs.study.jpa.model.dto.DirectorDto;
import kr.co.starlabs.study.jpa.service.DirectorService;
import kr.co.starlabs.study.jpa.service.PostService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/directors")
public class DirectorController {

	@Autowired
	private DirectorService directorService;

	@GetMapping(value = "")
	public ResponseEntity<List<DirectorDto.Read>> getAllDirectorWithFilmCount() {

		List<DirectorDto.Read> result = directorService.findAllDirectorWithFilmCount();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
