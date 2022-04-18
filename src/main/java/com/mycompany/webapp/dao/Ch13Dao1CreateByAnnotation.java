package com.mycompany.webapp.dao;

import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j2;

@Repository("ch13Dao1CreateByAnnotation")
@Log4j2
public class Ch13Dao1CreateByAnnotation {
	public Ch13Dao1CreateByAnnotation() {
		log.info("실행");
	}
}
