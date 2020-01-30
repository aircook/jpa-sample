package kr.co.starlabs.study.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.starlabs.study.jpa.model.entity.Account;
import kr.co.starlabs.study.jpa.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional(readOnly = true)
    public Page<Account> findAllAccounts(Pageable pageable) {
        return accountRepository.findAllByOrderByCreatedDesc(pageable);
    }
	
}
