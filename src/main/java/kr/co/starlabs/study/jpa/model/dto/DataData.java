package kr.co.starlabs.study.jpa.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DataData implements Serializable{

	private static final long serialVersionUID = -8111293874663507473L;

	private String sourceId;
	
    private String itemId;


}
