package kr.co.starlabs.study.jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.starlabs.study.jpa.entity.Account;
import kr.co.starlabs.study.jpa.entity.Address;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

	@Autowired
	AccountRepository accountRepository; 
	
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

}
