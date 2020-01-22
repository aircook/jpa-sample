package kr.co.starlabs.study.jpa.runner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kr.co.starlabs.study.jpa.entity.Account;
import kr.co.starlabs.study.jpa.entity.Address;
import kr.co.starlabs.study.jpa.entity.Study;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(JpaRunner.class);
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		logger.debug("application run");
		
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
		
		//관계의 주인은 study이기때문에 study를 통하여 관계를 적용한다.
		Study study = new Study();
		study.setName("Spring Data JPA");
		study.setOwner(account);
		
		//account.getStudies().add(study);
		
		
		Session session = entityManager.unwrap(Session.class);
		session.save(account);
		session.save(study);
		//entityManager.persist(account);
		
	}
	
}
