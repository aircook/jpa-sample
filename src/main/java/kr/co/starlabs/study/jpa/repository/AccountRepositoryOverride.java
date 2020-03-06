package kr.co.starlabs.study.jpa.repository;

import java.util.List;

import kr.co.starlabs.study.jpa.model.dto.AccountDto;
import kr.co.starlabs.study.jpa.model.entity.Account;

//https://noep.github.io/2017/05/03/springboot-querydsl/
//https://www.popit.kr/querydsl%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%B4%EC%84%9C-repository-%ED%99%95%EC%9E%A5%ED%95%98%EA%B8%B0/
public interface AccountRepositoryOverride {

	/**
	 * 최근 가입한 유저목록을 limit 갯수만큼 가져온다. 
	 * @param limit
	 * @return
	 */
	List<Account> findRecentlyRegistered(int limit, String name);

	
}
