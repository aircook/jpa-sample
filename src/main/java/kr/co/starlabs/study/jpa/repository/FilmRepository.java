package kr.co.starlabs.study.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import kr.co.starlabs.study.jpa.model.entity.Account;
import kr.co.starlabs.study.jpa.model.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Long>, QuerydslPredicateExecutor<Account>{
	
}
