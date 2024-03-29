<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>    
<ul>
	<li>
		<a href="javascript:;" data-go-link="/">INDEX</a>
	</li>
	<li>
		<a href="javascript:;" data-go-link="/dummy">DUMMY</a>
	</li>
	<security:authorize url="/notice/board" method="get">
		<li>
			<a href="javascript:;" data-go-link="/notice/board">게시글 목록</a>
		</li>
	</security:authorize>
</ul>
