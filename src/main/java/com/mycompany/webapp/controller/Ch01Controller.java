package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ch01Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch01Controller.class);
	
	// @RequestMapping(요청메시지): 해당 요청 메시지가 들어올 경우 아래의 메소드 실행
	@RequestMapping("/ch01/content")
	public String content() {
		logger.info("실행");
		return "ch01/content";
	}
}
