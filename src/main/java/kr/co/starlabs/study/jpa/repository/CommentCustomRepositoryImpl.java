package kr.co.starlabs.study.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.starlabs.study.jpa.model.dto.CommentDto;
import kr.co.starlabs.study.jpa.model.dto.CommentDto.Info;
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
	public List<Tuple> findAllCommentPosts() {

		JPAQueryFactory queryFactory = new JPAQueryFactory(this.getEntityManager());

		final QComment comment = QComment.comment;
		final QPost post = QPost.post;

		List<Tuple> result = queryFactory
				.select(comment.id, comment.title, post.id, post.title)
				.from(comment)
				.innerJoin(post)
				.on(comment.post.id.eq(post.id))
				.fetch();

		return result;

	}

	@Override
	public List<CommentDto.Info> findAllBySubQuery(String title) {
		/*
		 * SELECT * FROM comment WHERE post_id IN (select id FROM post WHERE title LIKE
		 * '%like%')
		 */
		JPAQueryFactory queryFactory = new JPAQueryFactory(this.getEntityManager());

		final QComment comment = QComment.comment;
		final QPost post = QPost.post;

		List<CommentDto.Info> result = queryFactory
				.select(Projections.constructor(CommentDto.Info.class, comment.id, comment.title, comment.post.id))
				.from(comment)
				.where(comment.post.id.in(
						JPAExpressions
							.select(post.id)
							.from(post)
							.where(post.title.contains(title))))
				.orderBy(comment.id.asc())
				.fetch();

		return result;

	}

}
