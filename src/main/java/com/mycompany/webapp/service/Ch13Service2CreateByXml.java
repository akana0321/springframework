package com.mycompany.webapp.service;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Ch13Service2CreateByXml {
	public Ch13Service2CreateByXml() {
		log.info("실행");
	}
	
	public static Ch13Service2CreateByXml getInstance1() {
		log.info("실행");
		Ch13Service2CreateByXml obj = new Ch13Service2CreateByXml();
		return obj;
	}
	
	public Ch13Service2CreateByXml getInstance2() {
		log.info("실행");
		Ch13Service2CreateByXml obj = new Ch13Service2CreateByXml();
		return obj;
	}
}
