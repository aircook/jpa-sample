package kr.co.starlabs.study.jpa.repository;

import java.util.List;

import com.querydsl.core.Tuple;

public interface PostCustomRepository {

	List<String> findAllPostWithCommentCount();
	
}