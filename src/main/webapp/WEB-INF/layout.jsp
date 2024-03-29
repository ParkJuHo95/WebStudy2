<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
<tiles:insertAttribute name="preScript"/>
<c:if test="${not empty message }">
	<script>
		alert("${message}");
	</script>
</c:if>
</head>
<body data-context-path="${pageContext.request.contextPath }">
<tiles:insertAttribute name="headerMenu" />
<hr />

<tiles:insertAttribute name="contentPage"/>

<hr />

<tiles:insertAttribute name="postScript"/>
</body>
</html>














