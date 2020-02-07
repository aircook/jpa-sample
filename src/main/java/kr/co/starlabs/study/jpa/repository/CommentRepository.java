package kr.co.starlabs.study.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import kr.co.starlabs.study.jpa.model.dto.CommentDto;
import kr.co.starlabs.study.jpa.model.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentCustomRepository, QuerydslPredicateExecutor<Comment>{

	List<CommentDto.Info1> findByTitle(String title);
	
	//DynamicProjections, Generic Method 정의
	<T> List<T> findByTitle(String title, Class<T> clazz);
	
}
