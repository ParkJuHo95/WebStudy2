<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<security:csrfMetaTags/>
<title>Insert title here</title>
</head>
<body>
<form method="post">
	<security:csrfInput/>
	<input type="text" name="username" />
	<input type="password" name="password" />
	<input type="submit" value="로그인" />
</form>
</body>
</html>