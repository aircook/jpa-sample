package kr.co.starlabs.study.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.Query;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.starlabs.study.jpa.model.dto.CommentDto;
import kr.co.starlabs.study.jpa.model.dto.CommentDto.Info;
import kr.co.starlabs.study.jpa.model.entity.Comment;
import kr.co.starlabs.study.jpa.model.entity.QComment;
import kr.co.starlabs.study.jpa.model.entity.QPost;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommentRepositoryImpl extends QuerydslRepositorySupport implements CommentRepositoryOverride {

	public CommentRepositoryImpl() {
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

	@Override
	public List<Comment> findAllByPageable(Pageable pageable) {
		
		final QComment comment = QComment.comment;
		
		//final JPQLQuery<Comment> query = from(comment).orderBy(comment.id.desc());
		//return getQuerydsl().applyPagination(pageable, query).fetch();
		
		//select comment0_.id as id1_2_, comment0_.post_id as post_id3_2_, comment0_.title as title2_2_ from comment comment0_ order by comment0_.id desc limit ?
	
		JPAQueryFactory queryFactory = new JPAQueryFactory(this.getEntityManager());
		//JPAQuery<Comment> jpaQuery = queryFactory.selectFrom(comment).offset(pageable.getOffset()).limit(pageable.getPageSize()).orderBy(comment.id.desc());
		//return jpaQuery.fetch();
		return queryFactory.selectFrom(comment).offset(pageable.getOffset()).limit(pageable.getPageSize()).orderBy(comment.id.desc()).fetch();
	}

}
