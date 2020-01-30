package kr.co.starlabs.study.jpa.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.starlabs.study.jpa.model.dto.AccountDto;
import kr.co.starlabs.study.jpa.model.dto.AccountDto.ListInfo;
import kr.co.starlabs.study.jpa.model.entity.Account;
import kr.co.starlabs.study.jpa.service.AccountService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;


    @Autowired
    private ModelMapper modelMapper;
	
	//example : http://localhost:8080/accounts?page=1&size=5&sort=age,desc
	@GetMapping(value = "")
    public ResponseEntity<Page<ListInfo>> getAccounts(Pageable pageable) {
		log.debug("pageable is [{}]", pageable);
                
        Page<Account> accounts =  accountService.findAllAccounts(pageable);
        
        //생성자 이용
        //Page<AccountDto.List> result = accounts.map(account -> new AccountDto.List(account));

        //model mapper 이용
        Page<ListInfo> result = accounts.map(account -> modelMapper.map(account, ListInfo.class));
                
        log.debug("result is [{}]", result);
        
        //return new ResponseEntity<>(result.getContent(), HttpStatus.OK);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	
}
