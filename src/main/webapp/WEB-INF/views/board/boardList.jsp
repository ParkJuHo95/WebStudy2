<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
BOARDLIST 예뻐져라~
<table class="table table-bordered">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty boardList }">
			<c:forEach items="${boardList }" var="board">
				<tr>
					<td>${board.rnum }</td>
					<td>
						<c:if test="${board.level gt 1 }">
							<c:forEach begin="2" end="${board.level }">
							&emsp; 
							</c:forEach>
							re:
						</c:if>
						<a href="<c:url value='/${boardType }/board/${board.boNo }'/>">${board.boTitle }</a>
					</td>
					<td>${board.boWriter }</td>
					<td>${board.boDate }</td>
					<td>${board.boHit }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty boardList }">
			<tr>
				<td colspan="5">글 없음.</td>
			</tr>
		</c:if>
	</tbody>
</table>
<a href="<c:url value='/${boardType}/board/insert' />">새글쓰기</a>