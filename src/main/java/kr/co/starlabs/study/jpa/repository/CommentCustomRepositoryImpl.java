package kr.co.starlabs.study.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.starlabs.study.jpa.model.entity.Comment;
import kr.co.starlabs.study.jpa.model.entity.QComment;
import kr.co.starlabs.study.jpa.model.entity.QPost;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommentCustomRepositoryImpl extends QuerydslRepositorySupport implements CommentCustomRepository {

	
	public CommentCustomRepositoryImpl() {
		super(Comment.class);
	}

	@Override
	public List<Tuple> findwithPost() {
	
		JPAQueryFactory queryFactory = new JPAQueryFactory(this.getEntityManager());
		
		final QComment comment = QComment.comment;
		final QPost post = QPost.post;

		List<Tuple> result = queryFactory.select(comment.id, comment.title, post.id, post.title).from(comment)
				.innerJoin(post)
				.on(comment.post.id.eq(post.id))
				.fetch();
		
		return result;
		
		
	}

}
