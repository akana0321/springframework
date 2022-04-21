package com.mycompany.webapp.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Log4j2
public class Ch15Aspect4AfterReturning {
	// returning -> 실제 pointcut에 준 메소드가 실행한 후의 리턴값
	@AfterReturning(pointcut="execution(public * com.mycompany.webapp.controller.Ch15Controller.afterReturning*(..))",
					returning="returnValue" )
	public void method(String returnValue) {
		log.info("실행");
		log.info("리턴값: " + returnValue);
	}
}
