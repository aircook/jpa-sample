package kr.co.starlabs.study.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.Tuple;

import kr.co.starlabs.study.jpa.model.dto.CommentDto;
import kr.co.starlabs.study.jpa.model.entity.Comment;
import kr.co.starlabs.study.jpa.model.entity.Post;
import kr.co.starlabs.study.jpa.repository.CommentRepository;
import kr.co.starlabs.study.jpa.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CommentService {
	
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;
	
    @Autowired
    private ModelMapper modelMapper;
	
    /* 테스트용 data.sql로 대체
    @PostConstruct
    public void initialize() {
    	
		Post post = new Post();
		post.setTitle("글 제목1입니다.");
		
		Comment comment1 = new Comment();
		comment1.setTitle("댓글 1입니다.");
		post.addComment(comment1);
		
		Comment comment2 = new Comment();
		comment2.setTitle("댓글 2입니다.");
		post.addComment(comment2);
		
		postRepository.save(post);
    	
    }
    */
    
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