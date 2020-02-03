package kr.co.starlabs.study.jpa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@GetMapping(value = "")
    public ResponseEntity<List<CommentDto.ListInfo>> getComments() {
        
        List<CommentDto.ListInfo> result = commentService.findAllComments();
        
        //return new ResponseEntity<>(result.getContent(), HttpStatus.OK);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	
}
