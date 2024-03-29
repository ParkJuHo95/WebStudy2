<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.or.ddit.board.controller.BoardInsertController"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script src="${pageContext.request.contextPath }/resources/js/ckeditor5/build/ckeditor.js"></script>

<form:form method="post" enctype="multipart/form-data"
	modelAttribute="${BoardInsertController.MODELNAME }">
	<table>
		<tr>
			<th>제목</th>
			<td><form:input type="text" path="boTitle" required="true"
					cssClass="form-control" />
				<form:errors path="boTitle" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>파일</th>
			<td>
				<input type="file" name="boFiles" multiple />
				<input type="file" name="boFiles" multiple />
			</td>
		</tr>
		<tr>
			<th>아이피</th>
			<td><form:input type="text" path="boIp" required="true" value="${pageContext.request.remoteAddr }"
					cssClass="form-control" readonly="true"/>
				<form:errors path="boIp" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><form:input type="text" path="boMail"
					cssClass="form-control" />
				<form:errors path="boMail" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><form:input type="text" path="boPass" required="true"
					cssClass="form-control" />
				<form:errors path="boPass" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<form:textarea path="boContent"/>
				<form:errors path="boContent" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="전송" />
			</td>
		</tr>
	</table>
</form:form>

<script>
    ClassicEditor
        .create( document.querySelector( '#boContent' ) )
        .catch( error => {
            console.error( error );
        } );
</script>














