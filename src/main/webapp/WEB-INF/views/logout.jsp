<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그아웃 할래?
<form:form method="post" action="${pageContext.request.contextPath }/logout">
	<input type="submit" value="로그아웃"  />
	<input type="button" value="아니요"  
		onclick="history.back();"
	/>
</form:form>
</body>
</html>