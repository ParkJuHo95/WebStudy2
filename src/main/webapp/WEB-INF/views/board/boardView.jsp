<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>	
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>	
BOARDVIEW 디자인이 이미 있다~
<table>
	<tr>
		<th>글번호</th>
		<td>${board.boNo}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${board.boTitle}</td>
	</tr>
	<tr>
		<th>파일</th>
		<td>
			<c:forEach items="${board.attatchList }" var="atch">
				<a href="<c:url value='/board/download/${atch.attNo }' />">${atch.attFilename }(${atch.attFancysize })</a>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${board.boWriter}</td>
	</tr>
	<tr>
		<th>아이피</th>
		<td>${board.boIp}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${board.boMail}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${board.boPass}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${board.boContent}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${board.boDate}</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${board.boHit}</td>
	</tr>
	<tr>
		<th>상위글번호</th>
		<td>${board.boParent}</td>
	</tr>
</table>
<a href="<c:url value='/${boardType}/board/${boNo}/child' />">답글쓰기</a>
<a href="<c:url value='/${boardType}/board/${boNo}/update' />">수정하기</a>










