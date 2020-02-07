package kr.co.starlabs.study.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;

import kr.co.starlabs.study.jpa.model.dto.CommentDto;
import kr.co.starlabs.study.jpa.model.entity.Comment;
import kr.co.starlabs.study.jpa.model.entity.QComment;
import kr.co.starlabs.study.jpa.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Comment 서비스 레이어
 * <p>기본적인 전략은 repository 객체에서 entity를 리턴하고 service에서 dto로 변환한다.
 * @author Francis Lee (yhlee@starlabs.co.kr)
 *
 */
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
		
		//ModelMapper는 기본생성자를 필요로 한다.CommentDto.Info 에 기본생성자가 정의되어 있어야 한다.
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
	public List<CommentDto.Info1> findByTitle(String title){
		
		//return commentRepository.findByTitle(title).stream().map(c -> modelMapper.map(c, CommentDto.Info.class)).collect(Collectors.toList());
		
		//이걸 잘보면 repository에서 entity가 아닌 dto를 바로 리턴하게 만들었다. 근데 리턴받을 타입클래스의 기본생성자가 있으면 동작하지 않는다.
		//return commentRepository.findByTitle(title);
		
		return commentRepository.findByTitle(title, CommentDto.Info1.class);
		
	}
	
	@Transactional(readOnly = true)
	public List<CommentDto.Info> findAllBySubQuery(String title){
		
		return commentRepository.findAllBySubQuery(title);
		
	}
	
	
	
	
	
}