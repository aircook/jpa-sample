package kr.co.starlabs.study.jpa.common.runner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kr.co.starlabs.study.jpa.model.entity.Account;
import kr.co.starlabs.study.jpa.model.entity.Address;
import kr.co.starlabs.study.jpa.model.entity.Comment;
import kr.co.starlabs.study.jpa.model.entity.Post;
import kr.co.starlabs.study.jpa.model.entity.Study;

@Component
@Transactional
//public class JpaRunner implements ApplicationRunner {
public class JpaRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(JpaRunner.class);

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		logger.debug("application run -----------------------------");

		Session session = entityManager.unwrap(Session.class);
		
		Address address = new Address();
		address.setCity("Seoul");
		address.setState("Kangnam");
		address.setStreet("Teheran");
		address.setZipCode("45154");

		
		
		
		// Study와 Account의 관계는 부모관계는 아니다. 부모사이관계는 객체간의 관계가 독립적이지 않고 밀접하게 관게되어 있다.
		// 즉, 부모없는 자식은 존재할수 없는 관계들
		Account account = new Account();
		account.setUsername("francis");
		account.setPassword("hibernate");
		account.setAge(25);
		account.setAddress(address);
		
		// 관계의 주인은 study이기때문에 study를 통하여 관계를 적용한다.
		Study study = new Study();
		study.setName("Spring Data JPA");
		study.setOwner(account);

		// account.getStudies().add(study);

		session.save(account);
		session.save(study);
		// entityManager.persist(account);

		for (int i = 0; i < 10; i++) {
			Account testAccount = new Account();
			testAccount.setUsername("francis" + i);
			testAccount.setPassword("hibernate" + i);
			testAccount.setAge(25);
			testAccount.setAddress(address);
			session.save(testAccount);
		}

		
		
		Post post = new Post();
		post.setTitle("글 제목입니다.");
		
		Comment comment1 = new Comment();
		comment1.setTitle("댓글 1입니다.");
		post.addComment(comment1);
		
		Comment comment2 = new Comment();
		comment2.setTitle("댓글 2입니다.");
		post.addComment(comment2);
		
		session.save(post);

	}

}
