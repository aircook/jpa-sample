package kr.co.starlabs.study.jpa.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;

import kr.co.starlabs.study.jpa.model.dto.CommentDto;
import kr.co.starlabs.study.jpa.model.dto.CommentDto.Info;
import kr.co.starlabs.study.jpa.model.dto.DirectorDto;
import kr.co.starlabs.study.jpa.model.entity.Comment;
import kr.co.starlabs.study.jpa.model.entity.Director;
import kr.co.starlabs.study.jpa.model.entity.QComment;
import kr.co.starlabs.study.jpa.repository.CommentRepository;
import kr.co.starlabs.study.jpa.repository.DirectorRepository;
import kr.co.starlabs.study.jpa.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Post 서비스 레이어
 * <p>기본적인 전략은 repository 객체에서 entity를 리턴하고 service에서 dto로 변환한다.
 * @author Francis Lee (yhlee@starlabs.co.kr)
 *
 */
@Service
@Transactional
@Slf4j
public class DirectorService {
	
	@Autowired
	private DirectorRepository directorRepository; 
	
    
	@Transactional(readOnly = true)
    public List<DirectorDto.Read> findAllDirectorWithFilmCount() {
		
		List<Tuple> directors = directorRepository.findAllDirectorWithFilmCount();
		
		log.debug("directors is [{}]", directors);
		
		List<DirectorDto.Read> result = new ArrayList<>();
		
		directors.stream().forEach(d -> {
			log.debug("d is [{}]", d);
			
			
			Director director = d.get(0, Director.class);
			
			DirectorDto.Read info = new DirectorDto.Read(
					director.getId(),
					director.getName(),
					director.getBirthDate(),
					director.getCreated(),
					d.get(1, Long.class));
			
//			DirectorDto.Read info = new DirectorDto.Read(
//					d.get(0, Long.class),
//					d.get(1, String.class),
//					d.get(2, LocalDate.class),
//					d.get(3, LocalDateTime.class),
//					d.get(4, Long.class));
			
			result.add(info);
		});

		return result;
    }
	
}