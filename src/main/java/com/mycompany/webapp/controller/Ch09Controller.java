package com.mycompany.webapp.controller;

import java.io.File;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.webapp.dto.Ch09Dto;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch09")
@Log4j2
public class Ch09Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch09/content";
	}
	
	@PostMapping("/fileupload")
	public String fileupload(String title, String desc, MultipartFile attach) throws Exception {
		log.info("실행");
		log.info("title: " + title);
		log.info("desc: " + desc);
		
		log.info("file originalname: " + attach.getOriginalFilename());
		log.info("file contenttype: " + attach.getContentType());
		log.info("file size: " + attach.getSize());
		
		// 파일의 순수 데이터(바이트 배열, 받은 파일을 나중에 DB에 저장할 때 사용), 둘 중 하나 사용
		// byte[] bytes = attach.getBytes();
		// InputStream is = attach.getInputStream();
		
		// 받은 파일을 서버 파일 시스템에 저장하는 코드
		String saveFilename = new Date().getTime() + "-" + attach.getOriginalFilename();
		File file = new File("C://Temp/uploadfiles/" + saveFilename);
		attach.transferTo(file);
		return "redirect:/ch09/content";
	}
	
	@PostMapping(value="/fileuploadAjax", produces="application/json; charset=UTF-8")
	@ResponseBody
//	public String fileuploadAjax(String title, String desc, MultipartFile attach) throws Exception {
	public String fileuploadAjax(Ch09Dto dto) throws Exception {
		log.info("실행");
		log.info("title: " + dto.getTitle());
		log.info("desc: " + dto.getDesc());
		
		// 다 DB에 저장할 내용(다운로드 받을 때 필요함)
		log.info("file originalname: " + dto.getAttach().getOriginalFilename());
		log.info("file contenttype: " + dto.getAttach().getContentType());
		log.info("file size: " + dto.getAttach().getSize());
		
		// 파일의 순수 데이터(바이트 배열, 받은 파일을 나중에 DB에 저장할 때 사용), 둘 중 하나 사용
		// byte[] bytes = attach.getBytes();
		// InputStream is = attach.getInputStream();
		
		// 받은 파일을 서버 파일 시스템에 저장하는 코드
		String saveFilename = new Date().getTime() + "-" + dto.getAttach().getOriginalFilename();
		File file = new File("C://Temp/uploadfiles/" + saveFilename);
		dto.getAttach().transferTo(file);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		jsonObject.put("saveFilename", saveFilename);
		String json = jsonObject.toString();
		return json;
	}
}
