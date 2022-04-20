package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch13DaoInterface;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Ch13Service5InjectInterface {
	public Ch13Service5InjectInterface() {
		log.info("실행");
	}
	
	// 인터페이스에 주입(필드)
	@Autowired @Qualifier("ch13DaoImplement1")
	private Ch13DaoInterface ch13DaoInterface1;
	@Resource(name="ch13DaoImplement2")
	private Ch13DaoInterface ch13DaoInterface2;
	
	// 인터페이스에 주입(Setter)
	@Autowired
	public void setCh13DaoInterface1(@Qualifier("ch13DaoImplement1") Ch13DaoInterface ch13DaoInterface1) {
		log.info("실행");
		this.ch13DaoInterface1 = ch13DaoInterface1;
	}
	@Resource(name="ch13DaoImplement2")
	public void setCh13DaoInterface2(Ch13DaoInterface ch13DaoInterface2) {
		log.info("실행");
		this.ch13DaoInterface2 = ch13DaoInterface2;
	}
}
