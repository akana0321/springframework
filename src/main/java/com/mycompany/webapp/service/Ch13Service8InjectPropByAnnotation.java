package com.mycompany.webapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Ch13Service8InjectPropByAnnotation {
	@Value("${service.prop1}") private int prop1;	// 필드 주입
	private double prop2;
	private boolean prop3;
	private String prop4;

	/*public Ch13Service8InjectPropByAnnotation() {
		log.info("실행2: " + toString());
	}*/
	
	// 생성자 주입
	public Ch13Service8InjectPropByAnnotation(@Value("${service.prop2}")double prop2,
			@Value("${service.prop3}") boolean prop3) {
		this.prop2 = prop2;
		this.prop3 = prop3;
		log.info("실행2: " + toString());
	}

	public void setProp1(int prop1) {
		this.prop1 = prop1;
		log.info("실행2: " + toString());
	}

	public void setProp2(double prop2) {
		this.prop2 = prop2;
		log.info("실행2: " + toString());
	}

	public void setProp3(boolean prop3) {
		this.prop3 = prop3;
		log.info("실행2: " + toString());
	}

	// Setter 주입
	@Value("${service.prop4}")
	public void setProp4(String prop4) {
		this.prop4 = prop4;
		log.info("실행2: " + toString());
	}

	@Override
	public String toString() {
		String str = "{";
		str += "pro1:" + prop1 + ", ";
		str += "pro2:" + prop2 + ", ";
		str += "pro3:" + prop3 + ", ";
		str += "pro4:" + prop4;
		str += "}";
		return str;
	}
}
