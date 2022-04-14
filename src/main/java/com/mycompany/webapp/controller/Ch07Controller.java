package com.mycompany.webapp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.webapp.dto.Ch07Board;
import com.mycompany.webapp.dto.Ch07City;
import com.mycompany.webapp.dto.Ch07Cloth;
import com.mycompany.webapp.dto.Ch07Member;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch07")
@Log4j2
public class Ch07Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch07Controller.class);
	// Controller에 field 선언하는 건 좋지 않음 - 모든 클라이언트가 사용 가능, 예제를 위해 만드는 것
	private int count;
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request) {
		logger.info("실행");
		log.info("실행");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(date);
		
		request.setAttribute("strDate", strDate);	// "strDate"라는 key이름으로 strDate값을 request에 저장하겠다는 뜻
		
		return "ch07/content";
	}
	
	@RequestMapping("/requestScopeSave")
	public String requestScopeSave(HttpServletRequest request) {
		// request 범위의 객체 저장
		request.setAttribute("requestScopeValue", "request 범위");
		
		// 멤버 객체 생성 후 request 범위에 객체 저장
		Ch07Member member = new Ch07Member();
		member.setName("홍길동");
		member.setAge(25);
		member.setJob("프로그래머");
		Ch07City city = new Ch07City();
		city.setName("서울");
		member.setCity(city);
		request.setAttribute("member", member);		
		
		return "ch07/content";
	}
	
	@RequestMapping("/sessionScopeSave")
	public String sessionScopeSave(HttpSession session) {
		// session 범위의 객체 저장(값을 session에 저장)
		session.setAttribute("sessionScopeValue", "session 범위");
		
		// 멤버 객체 생성 후 request 범위에 객체 저장
		Ch07Member member = new Ch07Member();
		member.setName("감자바");
		member.setAge(27);
		member.setJob("개발자");
		Ch07City city = new Ch07City();
		city.setName("제주");
		member.setCity(city);
		session.setAttribute("member2", member);	
		
		return "ch07/content";
	}
	
	@RequestMapping("/applicationScopeSave")
	public String applicationScopeSave(HttpServletRequest request) {
		// request로 application을 얻어와 값을 저장
		ServletContext application = request.getServletContext();
		application.setAttribute("applicationScopeValue", "application 범위");
		
		// 객체 생성 후 session 범위에 객체 저장
		Integer counter = ++count;
		application.setAttribute("counter", counter);
		return "ch07/content";
	}
	
	@GetMapping("/useJstl1")
	public String useJstl1(HttpServletRequest request) {
		String[] languages = {"Java", "Javascript", "Spring", "Vue"};
		request.setAttribute("langs", languages);
		return "ch07/useJstl1";
	}
	
	@GetMapping("/useJstl2")
	public String useJstl2(HttpServletRequest request) {
		List<Ch07Board> list = new ArrayList<>();	
		for(int i=0; i<=5; i++) {
			Ch07Board board = new  Ch07Board(i, "제목"+i, "내용"+i, "글쓴이"+i, new Date());
			list.add(board);
		}
		request.setAttribute("boardList", list);
		return "ch07/useJstl2";
	}
	
	// 예전 방식
	@GetMapping("/modelAndViewReturn")
	public ModelAndView modelAndViewReturn() {
		Ch07Board board = new  Ch07Board(1, "제목1", "내용1", "글쓴이1", new Date());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("board", board);
		modelAndView.setViewName("ch07/boardDetail");
		return modelAndView;
	}
	
	// 최근 작성하는 방법(가장 많이 쓰는 방법)
	@GetMapping("/modelArgument")
	public String modelArgument(Model model) {
		Ch07Board board = new  Ch07Board(1, "제목1", "내용1", "글쓴이1", new Date());
		model.addAttribute("board", board);	// request 범위로 저장 EL로 데이터를 읽을 수 있음
		return "ch07/boardDetail";
	}
	
	@GetMapping("/modelAttribute")
	public String modelAttribute(@ModelAttribute String kind, @ModelAttribute String sex) {
		return "ch07/clothInfo";
	}
	
	// 기본적으로 클래스 이름의 앞을 소문자로 한 것
	@GetMapping("/commandObject")
	public String commandObject(Ch07Cloth cloth) {
		return "ch07/clothInfo";
	}

	/* key 이름 변경
	@GetMapping("/commandObject")
	public String commandObject(@ModelAttribute("cloth") Ch07Cloth cloth) {
		return "ch07/clothInfo";
	}
	*/
}
