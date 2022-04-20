package com.mycompany.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch13Dao1CreateByAnnotation;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Ch13Service3InjectAnnotation {
	public Ch13Service3InjectAnnotation() {
		log.info("실행");
	}
	// 타입으로 주입(생성자나 Setter로 의존성을 주입할 경우 필드에 빼고 @Autowired 붙이면 됨)
	@Autowired
	private Ch13Dao1CreateByAnnotation ch13Dao;
	
	@Autowired
	public Ch13Service3InjectAnnotation(Ch13Dao1CreateByAnnotation ch13Dao) {
		log.info("실행: 타입으로 주입");
		this.ch13Dao = ch13Dao;
	}
	
	@Autowired
	public void setCh13Dao(Ch13Dao1CreateByAnnotation ch13Dao) {
		log.info("실행: 타입으로 주입");
		this.ch13Dao = ch13Dao;
	}

	/*// 이름으로 주입
	@Autowired @Qualifier("ch13Dao1")
	private Ch13Dao1CreateByAnnotation ch13Dao;
	
	@Autowired
	public Ch13Service3InjectAnnotation(
			@Qualifier("ch13Dao1") Ch13Dao1CreateByAnnotation ch13Dao) {
		log.info("실행: 이름으로 주입");
		this.ch13Dao = ch13Dao;
	}
	
	@Autowired
	public void setCh13Dao(@Qualifier("ch13Dao1") Ch13Dao1CreateByAnnotation ch13Dao) {
		log.info("실행: 이름으로 주입");
		this.ch13Dao = ch13Dao;
	}*/
}
