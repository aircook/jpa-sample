package kr.co.starlabs.study.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import kr.co.starlabs.study.jpa.model.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository, QuerydslPredicateExecutor<Post>{

}
