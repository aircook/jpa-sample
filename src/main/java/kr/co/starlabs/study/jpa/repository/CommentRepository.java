package kr.co.starlabs.study.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import kr.co.starlabs.study.jpa.model.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentCustomRepository, QuerydslPredicateExecutor<Comment>{

}