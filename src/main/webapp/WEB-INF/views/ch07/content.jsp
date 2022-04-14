<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<div class="card-header">
		JSP 템플릿 엔진 이해(.jsp -> .java -> .class)
	</div>
	
	<div class="card-body">
		index.jsp
		<hr/>
		<%-- 오늘 날짜: <%=request.getAttribute("strDate") %> <br/> --%>
		오늘 날짜: ${ strDate }	<%-- Expression Language(EL): 변수에 대한 키만 넣으면 됨 --%>
	</div>
	
	<div class="card-header">
		객체 저장 범위
	</div>
	
	<div class="card-body">
		<p>request 범위 객체값: <%=request.getAttribute("requestScopeValue") %></p>
		<p>session 범위 객체값: <%=session.getAttribute("sessionScopeValue") %></p>
		<p>application 범위 객체값: <%=application.getAttribute("applicationScopeValue") %></p>
		
		<hr/>
		<%-- 어떻게 찾는가?(찾는 순서): request 범위 -> session 범위 -> application 범위 --%>
		<p>
			request 범위 객체값: ${ requestScopeValue }<br/>
			member's name: ${ member.name }<br/>
			member's age: ${ member.age }<br/>
			member's job: ${ member.job }<br/>
			member's city: ${ member.city.name }<br/>
		</p>
		<hr/>
		<p>
			session 범위 객체값: ${ sessionScopeValue }<br/>
			member2's name: ${ member2.name }<br/>
			member2's age: ${ member2.age }<br/>
			member2's job: ${ member2.job }<br/>
			member2's city: ${ member2.city.name }<br/>
		</p>
		<hr/>
		<p>
			application 범위 객체값: ${ applicationScopeValue }<br/>
			방문 카운팅: ${ counter }
		</p>
		
		<hr/>
		
		<a href="requestScopeSave" class="btn btn-info btn-sm mr-2">request 범위에 객체 저장</a>
		<a href="sessionScopeSave" class="btn btn-info btn-sm mr-2">session 범위에 객체 저장</a>
		<a href="applicationScopeSave" class="btn btn-info btn-sm mr-2">application 범위에 객체 저장</a>
	</div>
	
	<hr/>
			
	<div class="card-header">
		JSTL(Java Standard Tag Library)
	</div>
	
	<div class="card-body">
		<a href="useJstl1" class="btn btn-info btn-sm mr-2">JSTL 사용하기</a>
		<a href="useJstl2" class="btn btn-info btn-sm mr-2">JSTL 사용하기</a>
	</div>
	
	<hr/>
	
	<div class="card-header">
		ModelAndView로 객체 전달
	</div>
	
	<div class="card-body">
		<a href="ModelAndViewReturn" class="btn btn-info btn-sm mr-2">ModelAndView 리턴</a>
	</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>