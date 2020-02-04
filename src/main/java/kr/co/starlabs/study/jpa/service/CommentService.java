package kr.co.starlabs.study.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;

import kr.co.starlabs.study.jpa.model.dto.AccountDto;
import kr.co.starlabs.study.jpa.model.dto.CommentDto;
import kr.co.starlabs.study.jpa.model.entity.Comment;
import kr.co.starlabs.study.jpa.model.entity.QComment;
import kr.co.starlabs.study.jpa.repository.CommentRepository;
import kr.co.starlabs.study.jpa.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CommentService {
	
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
    public List<CommentDto.ListInfo> findAllCommentsPost() {
		
		List<Tuple> posts = commentRepository.findAllCommentPosts();
		
		log.debug("posts is [{}]", posts);
		
		List<CommentDto.ListInfo> result = new ArrayList<>();
		
		posts.stream().forEach(c -> {
			CommentDto.ListInfo info = new CommentDto.ListInfo(c.get(0, Long.class), c.get(1, String.class), c.get(2, Long.class), c.get(3, String.class));
			result.add(info);
		});

		return result;
    }
	
	@Transactional(readOnly = true)
	public List<CommentDto.Info> findAll() {
		
		//return commentRepository.findAll().map(comment -> modelMapper.map(comment, CommentDto.Info.class));
		
		List<Comment> comments = commentRepository.findAll();
		
		comments.forEach(c -> {
			log.debug("comment's post title is [{}]", c.getPost().getTitle());
		});
				
		return comments.stream().map(c -> modelMapper.map(c, CommentDto.Info.class)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<CommentDto.Info> findAllByComments() {
		
		Comment comment1 = new Comment();
		comment1.setId(1L);
		
		Comment comment2 = new Comment();
		comment2.setId(2L);

		//in 연산자를 테스트 해보자.
		Predicate predicate = QComment.comment
				.in(comment1, comment2);
		
		Iterable<Comment> comments = commentRepository.findAll(predicate);
		
		return StreamSupport.stream(comments.spliterator(), false).map(c -> modelMapper.map(c, CommentDto.Info.class)).collect(Collectors.toList());
		
	}
	
	@Transactional(readOnly = true)
	public List<CommentDto.Info> findByTitle(String title){
		
		return commentRepository.findByTitle(title).stream().map(c -> modelMapper.map(c, CommentDto.Info.class)).collect(Collectors.toList());
		
	}
	
	
}