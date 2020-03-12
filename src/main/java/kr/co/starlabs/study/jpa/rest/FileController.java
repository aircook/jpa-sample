package kr.co.starlabs.study.jpa.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/files")
public class FileController {

	@PostMapping(value = "")
	public ResponseEntity<Map<String, String>> add(@RequestParam("file") MultipartFile file, @RequestParam("foo") String foo) {
		log.debug("file is [{}]", file);
		log.debug("file Name is [{}]", file.getName());
		log.debug("file Size is [{}]", file.getSize());
		log.debug("file OriginalFilename is [{}]", file.getOriginalFilename());
		log.debug("file ContentType is [{}]", file.getContentType());
		log.debug("------------------------------------------------");
		log.debug("foo is [{}]", foo);
		
		Map<String, String> result = new HashMap<>();
		result.put("Name", file.getName());
		result.put("Size", String.valueOf(file.getSize()));
		result.put("OriginalFilename", file.getOriginalFilename());
		result.put("ContentType", file.getContentType());
		result.put("Foo", foo);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
