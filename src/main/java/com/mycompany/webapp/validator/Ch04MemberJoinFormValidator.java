package com.mycompany.webapp.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.webapp.dto.Ch04Member;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Ch04MemberJoinFormValidator implements Validator {

	// 유효성 검사가 가능한 객체인지 조사
	@Override
	public boolean supports(Class<?> clazz) {
		log.info("실행");
		// 클래스1.class.isAssignableForm(클래스2): 클래스2가 클래스1로 대입이 가능한가?
		boolean result = Ch04Member.class.isAssignableFrom(clazz);
		return result;
	}

	// supports 메소드가 ture를 리턴할 경우 유효성 검사 실시
	// Controller의 메소드의 @**Mapping으로 받은 인자를 target으로 지정
	// error은 어떤 것이 잘못 되었는지에 대해 저장
	@Override
	public void validate(Object target, Errors errors) {
		log.info("실행");
		Ch04Member member = (Ch04Member) target;
		
		// mid 검사
		if(member.getMid() == null || member.getMid().equals("")) {
			errors.rejectValue("mid", "errors.mid.required", "mid는 필수 입력 사항입니다.");
		} else {
			if(member.getMid().length() < 4) {
				errors.rejectValue("mid", "errors.mpassword.required", new Object[] {4},"mid는 4자 이상입니다");
			}
		}
		
		// mpassword 검사
		if(member.getMpassword() == null || member.getMpassword().equals("")) {
			errors.rejectValue("mpassword", "errors.mpassword.required", "mpassword는 필수 입력 사항입니다.");
		} else {
			if(member.getMpassword().length() < 8) {
				errors.rejectValue("mpassword", "errors.mpassword.minlength", new Object[] {8},"mpassword는 8자 이상입니다");
			}
		}
		
		// memail 검사
		if(member.getMemail() == null || member.getMemail().equals("")) {
			errors.rejectValue("memail", "errors.memail.required", "memail은 필수 입력 사항입니다.");
		} else {
			String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(member.getMemail());
			if(!matcher.matches()) {
				errors.rejectValue("memail", "errors.memail.invalid", "memail은 이메일 형식이 아닙니다.");
			}
		}
		
		//mtel 검사
		if(member.getMtel() == null || member.getMtel().trim().equals("")) {
		   errors.rejectValue("mtel", "errors.mtel.required", "mtel은 필수 입력 사항입니다.");
		} else {
		   String regex = "^\\d{3}-\\d{3,4}-\\d{4}$";
		   Pattern pattern = Pattern.compile(regex);
		   Matcher matcher = pattern.matcher(member.getMtel());
		   if(!matcher.matches()) {
			   errors.rejectValue("mtel", "errors.mtel.invalid", "mtel은 전화번호 형식이 아닙니다..");
		   }
		}
	}
}
