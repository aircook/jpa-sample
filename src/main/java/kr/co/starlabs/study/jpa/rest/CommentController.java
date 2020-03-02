package kr.co.starlabs.study.jpa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.starlabs.study.jpa.model.dto.CommentDto;
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
		
		List<CommentDto.Info> result = commentService.findAll();
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/t3")
	public ResponseEntity<List<CommentDto.Info>> getAllByComments(){
		
		List<CommentDto.Info> result = commentService.findAllByComments();
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/t4")
	public ResponseEntity<List<CommentDto.Info1>> getAllByTitle(@RequestParam String title){
		
		List<CommentDto.Info1> result = commentService.findByTitle(title);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/t5")
	public ResponseEntity<List<CommentDto.Info>> getAllBySubQuery(@RequestParam String title){
		
		List<CommentDto.Info> result = commentService.findAllBySubQuery(title);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	//?page=0&size=5
	@GetMapping(value = "/t6")
	public ResponseEntity<List<CommentDto.Info>> getAll(Pageable pageable){
		
		List<CommentDto.Info> result = commentService.findAll(pageable);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	
	
}
