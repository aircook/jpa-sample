package kr.co.starlabs.study.jpa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.starlabs.study.jpa.model.dto.AccountDto;
import kr.co.starlabs.study.jpa.service.AccountService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	// example : http://localhost:8080/accounts?page=1&size=5&sort=age,desc
	@GetMapping(value = "")
	public ResponseEntity<Page<AccountDto.ListInfo>> getAccounts(Pageable pageable) {
		log.debug("pageable is [{}]", pageable);

		Page<AccountDto.ListInfo> result = accountService.findAllAccounts(pageable);
		
		// return new ResponseEntity<>(result.getContent(), HttpStatus.OK);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
