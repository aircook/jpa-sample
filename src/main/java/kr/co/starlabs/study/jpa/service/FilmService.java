package kr.co.starlabs.study.jpa.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.starlabs.study.jpa.model.dto.FilmDto;
import kr.co.starlabs.study.jpa.model.entity.Film;
import kr.co.starlabs.study.jpa.repository.FilmRepository;
import lombok.extern.slf4j.Slf4j;

// Controller <- [DTO] -> Service <- [Entity] -> Repository
@Service
@Transactional
@Slf4j
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
    @Autowired
    private ModelMapper modelMapper;
	
	@Transactional(readOnly = true)
    public Page<FilmDto.Read> findAll(Pageable pageable) {
        //model mapper 이용
		Page<FilmDto.Read> result = filmRepository.findAll(pageable).map(film -> modelMapper.map(film, FilmDto.Read.class));
        log.debug("result is [{}]", result);
		return result;
    }
	
	@Transactional(readOnly = true)
	public Optional<FilmDto.Read> findById(Long id){
		//optinal 객체애 대한 처리는 어디서?
		Optional<FilmDto.Read> result = filmRepository.findById(id).map(film -> modelMapper.map(film, FilmDto.Read.class));
		log.debug("result is [{}]", result);
		return result;
	}
	
	//DTO의 값을 ENTITY 객체를 만든다음 저장
	public FilmDto.Read add(FilmDto.Insert insert) {
		log.debug("insert is [{}]", insert);
		/*
		Film film = Film.builder()
				.title(insert.getTitle())
				.director(insert.getDirector())
				.language(insert.getLanguage())
				.time(insert.getTime())
				.released(insert.getReleased())
				.created(LocalDateTime.now())
				.build();
		*/
		Film film = new Film();
		film.setTitle(insert.getTitle());
		film.setDirector(insert.getDirector());
		film.setLanguage(insert.getLanguage());
		film.setTime(insert.getTime());
		film.setReleased(insert.getReleased());
		film.setCreated(LocalDateTime.now());
		
		FilmDto.Read result = modelMapper.map(filmRepository.save(film), FilmDto.Read.class); 
		log.debug("result is [{}]", result);
		return result;
	}
	
	//Entity 객체를 가져온 다음 DTO의 값을 대입
	public Optional<FilmDto.Read> edit(FilmDto.Update update) {
		log.debug("update is [{}]", update);
		Optional<FilmDto.Read> result = 	
		filmRepository.findById(update.getId()).map(film -> {
			film.setTitle(update.getTitle());
			film.setDirector(update.getDirector());
			film.setLanguage(update.getLanguage());
			film.setTime(update.getTime());
			film.setReleased(update.getReleased());
			film.setCreated(LocalDateTime.now());
			//return film;
			return modelMapper.map(film, FilmDto.Read.class);
		});		
		
		//아래처럼 Servie layer에서 검증하는 코드로 수정해야 것다.
		//Film film = filmRepository.findById(update.getId()).orElseThrow(() -> new RuntimeException());
		//film.setTitle(update.getTitle());
		//return modelMapper.map(film, FilmDto.Read.class);
		
		
		log.debug("result is [{}]", result);
		return result;
	}
	
	
	public void remove(Long id) {
		log.debug("id is [{}]", id);
		//this.findById(id).ifPresent(film -> filmRepository.delete(modelMapper.map(film, Film.class)));
		filmRepository.findById(id).ifPresent(film -> filmRepository.delete(film));
	}
	
}
