package kr.co.starlabs.study.jpa.rest;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.starlabs.study.jpa.model.dto.FilmDto;
import kr.co.starlabs.study.jpa.service.FilmService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/films")
public class FilmController {

	@Autowired
	private FilmService filmService;

	// example : http://localhost:8080/films?page=0&size=5&sort=id,asc
	// example : http://localhost:8080/films?page=1&size=5&sort=director,asc
	@GetMapping(value = "")
	public ResponseEntity<Page<FilmDto.Read>> list(@PageableDefault(size=20, sort="director", direction = Direction.ASC) Pageable pageable) {
		log.debug("pageable is [{}]", pageable);
		Page<FilmDto.Read> films = filmService.findAll(pageable);
		// return new ResponseEntity<>(result.getContent(), HttpStatus.OK);
		return new ResponseEntity<>(films, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<FilmDto.Read> get(@PathVariable Long id) {
		log.debug("id is [{}]", id);
		FilmDto.Read film = filmService.findById(id).orElseThrow(NoSuchElementException::new);
		return new ResponseEntity<>(film, HttpStatus.OK);
	}

	/*
	{
	    "title": "베테랑",
	    "director": "류승완",
	    "language": "한국어",
	    "time": 124,
	    "released": "2015-09-18"
	}
	 */
	@PostMapping(value = "")
	public ResponseEntity<FilmDto.Read> add(@RequestBody FilmDto.Insert filmDto) {
		log.debug("filmDto is [{}]", filmDto);
		FilmDto.Read film = filmService.add(filmDto);
		return new ResponseEntity<>(film, HttpStatus.OK);
	}

	/*
	{
	    "title": "베테랑1",
	    "director": "류승완2",
	    "language": "한국어3",
	    "time": 1241,
	    "released": "2015-09-20"
	}
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<FilmDto.Read> edit(@PathVariable Long id, @RequestBody FilmDto.Update filmDto) {
		filmDto.setId(id);
		log.debug("filmDto is [{}]", filmDto);
		FilmDto.Read film = filmService.edit(filmDto).orElseThrow(NoSuchElementException::new);
		return new ResponseEntity<>(film, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		filmService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
