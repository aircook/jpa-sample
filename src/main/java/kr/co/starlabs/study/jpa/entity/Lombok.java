package kr.co.starlabs.study.jpa.entity;

import java.util.Date;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Lombok {
	
	private Long id;

	private String project;

	private Date created;

}
