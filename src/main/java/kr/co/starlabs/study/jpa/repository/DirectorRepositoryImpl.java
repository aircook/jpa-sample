package kr.co.starlabs.study.jpa.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.starlabs.study.jpa.model.dto.DirectorDto;
import kr.co.starlabs.study.jpa.model.dto.DirectorDto.Read;
import kr.co.starlabs.study.jpa.model.entity.Director;
import kr.co.starlabs.study.jpa.model.entity.QDirector;
import kr.co.starlabs.study.jpa.model.entity.QFilm;

public class DirectorRepositoryImpl extends QuerydslRepositorySupport implements DirectorRepositoryOverride {

	public DirectorRepositoryImpl() {
		super(Director.class);
	}
	
	@Autowired
	private JPAQueryFactory queryFactory;

	//JPQL은 기본적으로 Projection에 따라 영속성 컨텍스트에서 관리할지 안할지를 결정한다.
	//Projection에서 Entity를 사용하면 영속성 컨텍스트에서 관리되고, Embeded, Scalar를 사용하면 관리되지 않는다.
	//QueryDSL로 조회하는 기능에서는 영속성을 지닌 객체가 필요하지도 않고 대부분 새로만든 DTO를 Projection을 사용하게 된다.
	@Override
	public List<Read> findAllDirectorWithFilmCount() {
		
		final QDirector director = QDirector.director;
		final QFilm film = QFilm.film; 

		//쿼리를 아래와 같이 만드는게 목표		
		//SELECT a.id, a.birth_date, a.created, a.name, b.director_count
		//FROM director a
		//LEFT OUTER JOIN 
		//	(SELECT director_id, COUNT(*) AS director_count 
		//	 FROM film
		//	 GROUP BY director_id) b ON a.id = b.director_id	
		//
		//위처럼 만드는건 실패, sub query를 SELECT와 WHERE에만 사용가능하다. 	 
		//SELECT a.id, a.birth_date, a.created, a.name, (
		//	 SELECT COUNT(*)
		//	 FROM film b
		//	 WHERE a.id = b.director_id) AS director_count
		//	 FROM director a			 
		
		//return queryFactory.from(film).groupBy(film.directorId).select(film.directorId, Wildcard.count).fetch();
		
		//return queryFactory.select(director.id, director.name, director.birthDate, director.created,
		return queryFactory.select(
			Projections.bean(DirectorDto.Read.class, 	
				director.id, director.name, director.birthDate, director.created,
				ExpressionUtils.as(
						JPAExpressions.select(Wildcard.count)
							.from(film)
							.where(director.id.eq(film.directorId)), 
						"directorCount")
			)	
		).from(director).fetch();
		
	}
	

}
