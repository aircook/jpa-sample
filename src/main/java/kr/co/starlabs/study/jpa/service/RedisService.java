package kr.co.starlabs.study.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import kr.co.starlabs.study.jpa.model.dto.DataData;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RedisService implements MessageListener {

	public static List<String> messageList = new ArrayList<String>();

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public void onMessage(Message message, byte[] pattern) {

		log.debug("Message is [{}]", message.toString());
		messageList.add(message.toString());

	}

	public void set() {
		// get/set을 위한 객체
		ValueOperations<String, Object> vop = redisTemplate.opsForValue();
		// 자료형 생성
		DataData setData = new DataData();
		setData.setItemId("ThisisItem");
		setData.setSourceId("ThisisSource");
		// set
		vop.set("key", setData);
	}
	
	public DataData get() {
		
		ValueOperations<String, Object> vop = redisTemplate.opsForValue();
		DataData dataData = (DataData) vop.get("key");
		
		log.debug("dataData is [{}]", dataData);
		
		return dataData;
	}

}
