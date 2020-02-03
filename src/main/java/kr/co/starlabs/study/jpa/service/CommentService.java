package kr.co.starlabs.study.jpa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.Tuple;

import kr.co.starlabs.study.jpa.model.dto.CommentDto;
import kr.co.starlabs.study.jpa.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
    @Autowired
    private ModelMapper modelMapper;
	
	@Transactional(readOnly = true)
    public List<CommentDto.ListInfo> findAllComments() {
		
		List<Tuple> posts = commentRepository.findwithPost();
		
		log.debug("posts is [{}]", posts);
		
		List<CommentDto.ListInfo> result = new ArrayList<>();
		
		posts.stream().forEach(c -> {
			CommentDto.ListInfo info = new CommentDto.ListInfo(c.get(0, Long.class), c.get(1, String.class), c.get(2, Long.class), c.get(3, String.class));
			result.add(info);
		});

		return result;
    }
}