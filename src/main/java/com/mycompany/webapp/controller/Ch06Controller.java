package com.mycompany.webapp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch06")
@Log4j2
public class Ch06Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch06/content";
	}
	
	@GetMapping("/forward")
	public String forward() {
		return "ch06/forward";	// view가 달라짐
	}
	
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:/";
	}
	
	@GetMapping("/getFragmentHtml")
	public String getFragmentHtml() {
		return "ch06/fragmentHtml";
	}
	
	@GetMapping("/getJson1")
	public void getJson1(HttpServletResponse response) throws Exception {
		//{"fileName": "photo06.jpg"}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileName", "photo6.jpg");
		String json = jsonObject.toString();
		
		// json을 보내는 기본적은 방법
		// 1. 응답 내용의 타입이 무엇인지 설정(html? json?) -> WAS가 보내줌
		//    html일 경우: text/html; charset=UTF-8
		//    매우 중요한 부분, 브라우저가 가정 먼저 해석해서 이를 바탕으로 본문 해석
		response.setContentType("application/json; charset=UTF-8");
		
		// 2. 서버와 브라우저가 입력을 주고 받을 때 stream을 씀
		// Controller가 직접 응답을 만드는 경우임: DB의 그림파일을 가져와 client로 전송하는 경우도 있음
		PrintWriter pw = response.getWriter();
		// pw.write(json);
		pw.println(json);
		pw.flush(); pw.close();
	}
	
	@GetMapping(value="/getJson2", produces="application/json; charset=UTF-8")
	@ResponseBody	// return값이 응답 본문에 들어감
	public String getJson2() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileName", "photo7.jpg");
		String json = jsonObject.toString();
		return json;
	}
	
	@GetMapping("/getJson3")
	public String getJson3() {
		return "redirect:/";
	}
}
