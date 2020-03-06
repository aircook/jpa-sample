package kr.co.starlabs.study.jpa.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.starlabs.study.jpa.model.entity.Post;
import kr.co.starlabs.study.jpa.model.entity.QComment;
import kr.co.starlabs.study.jpa.model.entity.QPost;

public class PostRepositoryImpl extends QuerydslRepositorySupport implements PostRepositoryOverride {

	public PostRepositoryImpl() {
		super(Post.class);
	}
	
	@Autowired
	private JPAQueryFactory queryFactory;
	
	//Group By 테스트
	public List<String> findAllPostWithCommentCount(){
	
		//JPAQueryFactory queryFactory = new JPAQueryFactory(this.getEntityManager());
		
		final QPost post = QPost.post;
		final QComment comment = QComment.comment;
		
		List<String> result = queryFactory.from(post).groupBy(post.title).select(post.title).fetch();
		
		return result;
		
	}
}
