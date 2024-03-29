<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<h4>웰컴페이지</h4>
<script src="${pageContext.request.contextPath}/resources/js/app/index.js"></script>
<pre>
	spring security 기반의 선택적 랜더링
	<security:authorize access="isAuthenticated()">
		<security:authentication property="principal"/>
		<security:authentication property="details"/>
		<security:authentication property="authorities"/>
		<a href="<c:url value='/myLogout'/>">로그아웃</a>
	</security:authorize>
	<security:authorize access="isAnonymous()">
		<a href="<c:url value='/myLogin'/>">로그인</a>
	</security:authorize>
</pre>

