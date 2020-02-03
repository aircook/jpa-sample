package kr.co.starlabs.study.jpa.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.starlabs.study.jpa.model.dto.AccountDto;
import kr.co.starlabs.study.jpa.model.entity.Account;
import kr.co.starlabs.study.jpa.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
    @Autowired
    private ModelMapper modelMapper;
	
	@Transactional(readOnly = true)
    public Page<AccountDto.ListInfo> findAllAccounts(Pageable pageable) {
				
		Page<Account> accounts =  accountRepository.findAllByOrderByCreatedDesc(pageable);
        
        //생성자 이용
        //Page<ListInfo> result = accounts.map(account -> new ListInfo(account));

        //model mapper 이용
        Page<AccountDto.ListInfo> result = accounts.map(account -> modelMapper.map(account, AccountDto.ListInfo.class));
                
        log.debug("result is [{}]", result);
		
		return result;
    }
	
}
