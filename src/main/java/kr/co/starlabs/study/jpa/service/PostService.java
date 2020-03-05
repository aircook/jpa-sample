package kr.co.starlabs.study.jpa.service;

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
import kr.co.starlabs.study.jpa.model.entity.Comment;
import kr.co.starlabs.study.jpa.model.entity.QComment;
import kr.co.starlabs.study.jpa.repository.CommentRepository;
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
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
    
	@Transactional(readOnly = true)
    public List<String> findAllPostWithCommentCount() {
		
		List<String> posts = postRepository.findAllPostWithCommentCount();
		
		log.debug("posts is [{}]", posts);
		
		posts.stream().forEach(s -> {
			log.debug("s is [{}]", s);
		});

		return posts;
    }
	
}