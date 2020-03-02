package kr.co.starlabs.study.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.querydsl.core.Tuple;

import kr.co.starlabs.study.jpa.model.dto.CommentDto;
import kr.co.starlabs.study.jpa.model.entity.Comment;

public interface CommentCustomRepository {

	List<Tuple> findAllCommentPosts();
	
	List<CommentDto.Info> findAllBySubQuery(String title);
	
	List<Comment> findAllByPageable(Pageable pageable);
	
}
