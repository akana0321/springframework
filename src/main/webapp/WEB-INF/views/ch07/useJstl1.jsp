<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="card-header">
		JSTL을 이용해서 배열 반복 처리
	</div>
	
	<div class="card-body">
		<table class="table table-striped">
	         <thead>
	           <tr>
	             <th scope="col">No</th>
	             <th scope="col">Language</th>
	           </tr>
	         </thead>
	         
	         <tbody>
	         	<c:forEach items="${ langs }" var="lang" varStatus="status">
		         	<tr>
		         		<td>${ status.count }</td>
		         		<td>${ lang }</td>
		         	</tr>
	         	</c:forEach>
	         </tbody>
         </table>
	</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>