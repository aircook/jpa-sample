package kr.co.starlabs.study.jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

import kr.co.starlabs.study.jpa.model.entity.Account;
import kr.co.starlabs.study.jpa.model.entity.Address;
import kr.co.starlabs.study.jpa.model.entity.QAccount;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

	@Autowired
	private AccountRepository accountRepository; 
	
	/*
	@Test
	public void test() {
		Address address = new Address();
		address.setCity("Seoul");
		address.setState("Kangnam");
		address.setStreet("Teheran");
		address.setZipCode("45154");

		Account account = new Account();
		account.setUsername("francis");
		account.setPassword("hibernate");
		account.setAge(25);
		account.setAddress(address);
		
		Account savedAccount = accountRepository.save(account);
		log.debug("saved account is [{}]", savedAccount);
		assertThat(savedAccount).isNotNull();
		
		Iterable<Account> selectedAccount = accountRepository.findAll();
		log.debug("selected account is [{}]", selectedAccount);
		assertThat(selectedAccount).hasSize(1);
		
	}
	@Test
	public void dslFindOne() {
		Predicate predicate = QAccount.account
				.username.containsIgnoreCase("frank")
				.and(QAccount.account.age.eq(10));
		
		Optional<Account> account = accountRepository.findOne(predicate);
		assertThat(account).isEmpty();
	}
	*/
	
	@Test
	public void dslFindAll() {
		
		int limit = 5;
		String name = "test";
		
		List<Account> accounts = accountRepository.findRecentlyRegistered(limit, name);
		
		log.debug("accounts is [{}]", accounts);
		
		assertThat(accounts).hasSize(0);
		
	}

}
