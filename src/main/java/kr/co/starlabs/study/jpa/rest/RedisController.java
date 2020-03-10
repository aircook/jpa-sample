package kr.co.starlabs.study.jpa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.starlabs.study.jpa.model.dto.DataData;
import kr.co.starlabs.study.jpa.service.RedisService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisService redisService;

	@GetMapping(value = "/set")
	public ResponseEntity<Void> set() {
		redisService.set();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/get")
	public ResponseEntity<DataData> get() {
		
		return new ResponseEntity<>(redisService.get(), HttpStatus.OK);
		
	}
	
}
