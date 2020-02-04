package kr.co.starlabs.study.jpa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.starlabs.study.jpa.model.dto.CommentDto;
import kr.co.starlabs.study.jpa.model.dto.CommentDto.Info;
import kr.co.starlabs.study.jpa.service.CommentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	@GetMapping(value = "/t1")
    public ResponseEntity<List<CommentDto.ListInfo>> getAllCommentsPost() {
        
        List<CommentDto.ListInfo> result = commentService.findAllCommentsPost();
        
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@GetMapping(value = "/t2")
	public ResponseEntity<List<CommentDto.Info>> getAll() {
		
		log.debug("find all test 시작.");
		
		List<CommentDto.Info> result = commentService.findAll();
		
		log.debug("result is [{}]", result);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/t3")
	public ResponseEntity<List<CommentDto.Info>> getAllByComments(){
		
		List<CommentDto.Info> result = commentService.findAllByComments();
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/t4")
	public ResponseEntity<List<CommentDto.Info>> findByTitle(@RequestParam String title){
		
		List<CommentDto.Info> result = commentService.findByTitle(title);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	
	
}
