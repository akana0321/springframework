package com.mycompany.webapp.dao;

import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class Ch13DaoImplement1 implements Ch13DaoInterface{
	public Ch13DaoImplement1() {
		log.info("실행");
	}
}
