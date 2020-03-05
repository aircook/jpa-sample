package kr.co.starlabs.study.jpa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.Tuple;

import kr.co.starlabs.study.jpa.service.PostService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping(value = "/t1")
	public ResponseEntity<List<String>> getAllCommentsPost() {

		List<String> result = postService.findAllPostWithCommentCount();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
