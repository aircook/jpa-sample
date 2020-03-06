package kr.co.starlabs.study.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import kr.co.starlabs.study.jpa.model.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryOverride, QuerydslPredicateExecutor<Account>{

	List<Account> findByUsernameAndAgeLessThan(String name, int age);

	@Query("select t from Account t where username=:name and age < :age")
	List<Account> findByUsernameAndAgeLessThanSQL(@Param("name") String name, @Param("age") int age);

	List<Account> findByUsernameAndAgeLessThanOrderByAgeDesc(String name, int age);
	
	Page<Account> findAllByOrderByCreatedDesc(Pageable pageable);
	
	Page<Account> findAllByOrderByAgeDesc(Pageable pageable);
	
	
}
