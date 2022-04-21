package com.mycompany.webapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Order(2)	// 실행 순서(숫자가 작을수록 우선순위)
@Log4j2
public class Ch15Aspect1Before {
	// public이고 리턴 타입은 관계없고 ~~ 경로의 Ch15Controller 클래스의 before로 시작하는 메소드면서 매개값은 상관 없다
	@Before("execution(public * com.mycompany.webapp.controller.Ch15Controller.before*(..))")
	public void method() {
		log.info("실행");
	}
}
