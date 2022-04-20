package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch13Dao1CreateByAnnotation;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Ch13Service4InjectAnnotation {
	public Ch13Service4InjectAnnotation() {
		log.info("실행");
	}
	/*
	// 타입으로 주입
	@Resource
	private Ch13Dao1CreateByAnnotation ch13Dao;
	
	@Resource
	public void setCh13Dao(Ch13Dao1CreateByAnnotation ch13Dao) {
		log.info("실행: 타입으로 주입");
		this.ch13Dao = ch13Dao;
	}
	*/
	
	// 이름으로 주입
	@Resource(name="ch13Dao1")
	private Ch13Dao1CreateByAnnotation ch13Dao;
	
	@Resource(name="ch13Dao1")
	public void setCh13Dao(Ch13Dao1CreateByAnnotation ch13Dao) {
		log.info("실행: 이름으로 주입");
		this.ch13Dao = ch13Dao;
	}
}
