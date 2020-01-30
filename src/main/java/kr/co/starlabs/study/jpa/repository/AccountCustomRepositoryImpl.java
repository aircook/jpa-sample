package kr.co.starlabs.study.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import com.querydsl.core.BooleanBuilder;

import kr.co.starlabs.study.jpa.model.entity.Account;
import kr.co.starlabs.study.jpa.model.entity.QAccount;

public class AccountCustomRepositoryImpl extends QuerydslRepositorySupport implements AccountCustomRepository {

	public AccountCustomRepositoryImpl() {
		super(Account.class);
	}

	@Override
	public List<Account> findRecentlyRegistered(int limit, String name) {
		
		
		final QAccount account = QAccount.account;
		
		BooleanBuilder builder = new BooleanBuilder();
		if (!StringUtils.isEmpty(name)){
			builder.and(account.username.contains(name));
		}
		
        return from(account)
        		.where(builder)
                .limit(limit)
                .orderBy(account.created.desc())
                .fetch();
    }

}
