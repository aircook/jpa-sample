package kr.co.starlabs.study.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kr.co.starlabs.study.jpa.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	List<Account> findByUsernameAndAgeLessThan(String name, int age);

	@Query("select t from Account t where username=:name and age < :age")
	List<Account> findByUsernameAndAgeLessThanSQL(@Param("name") String name, @Param("age") int age);

	List<Account> findByUsernameAndAgeLessThanOrderByAgeDesc(String name, int age);

}
