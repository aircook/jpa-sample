package kr.co.starlabs.study.jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.Tuple;

import kr.co.starlabs.study.jpa.model.entity.QComment;
import kr.co.starlabs.study.jpa.model.entity.QPost;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
//https://github.com/HomoEfficio/dev-tips/blob/master/Spring%20%40DataJpaTest%20%EC%82%AC%EC%9A%A9%20Tips.md
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CommentRepositoryTest {

	@Autowired
	private CommentRepository commentRepository; 
	
	@Test
	void testFindwithPost() {
		
		final QComment comment = QComment.comment;
		final QPost post = QPost.post;

		
		List<Tuple> comments = commentRepository.findAllCommentPosts();
		
		log.debug("comments is [{}]", comments);
		
		for (Tuple tuple : comments) {
			log.debug("tuple (expre) is {}, {}, {}, {} ", tuple.get(comment.id), tuple.get(comment.title), tuple.get(post.id), tuple.get(post.title));
			log.debug("tuple (index) is {}, {}, {}, {} ", tuple.get(0, Long.class), tuple.get(1, String.class), tuple.get(2, Long.class), tuple.get(3, String.class));
		}
		
		
		assertThat(comments).isNotEmpty();
		
	}

}
