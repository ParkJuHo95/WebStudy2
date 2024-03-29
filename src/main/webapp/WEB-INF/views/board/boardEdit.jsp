<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.or.ddit.board.controller.BoardUpdateController"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script src="${pageContext.request.contextPath }/resources/js/ckeditor5/build/ckeditor.js"></script>
<c:set var="modelName" value="${BoardUpdateController.MODELNAME }"/>
<form:form id="updateForm" method="post" enctype="multipart/form-data" modelAttribute="${modelName }">
	<table>
		<tr>
			<th>제목</th>
			<td><form:input type="text" path="boTitle" required="true"
					cssClass="form-control" />
				<form:errors path="boTitle" cssClass="text-danger" /></td>
		</tr>
		<tr>
			<th>기존파일</th>
			<td>
				<c:forEach items="${requestScope[modelName].attatchList }" var="atch">
					<span>
						${atch.attFilename }
						<a data-att-no="${atch.attNo }" class="btn btn-danger" href="javascript:;">
							삭제						
						</a>
					</span>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th>파일</th>
			<td>
				<input type="file" name="boFiles" multiple />
				<input type="file" name="boFiles" multiple />
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><form:input type="text" path="boMail"
					cssClass="form-control" />
				<form:errors path="boMail" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="text" name="boPass" required class="form-control" />
				<form:errors path="boPass" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<form:textarea path="boContent"/>
				<form:errors path="boContent" cssClass="text-danger" />
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="전송" class="btn btn-primary" /> 
				<input type="button" value="삭제" class="btn btn-danger" id="delBtn"/> 
			</td>
		</tr>
	</table>
</form:form>
<form action="delete" method="post" id="deleteForm">
	<input type="hidden" name="boPass" required />
</form>
<script>
    ClassicEditor
        .create( document.querySelector( '#boContent' ) )
        .catch( error => {
            console.error( error );
        } );
    document.querySelectorAll("[data-att-no]").forEach(el=>{
    	el.addEventListener("click", e=>{
    		e.preventDefault();
    		let attNo = el.dataset.attNo;
    		fetch(`<c:url value='/board/atch'/>/\${attNo}`, {
    			method:"delete"
    			, headers:{
    				"accept":"application/json"
    			}
    		}).then(resp=>resp.json())
    		.then(json=>{
    			if(json.success){
					el.parentElement.remove();    				
    			}
    		}).catch(err=>console.error(err));
    	});
    });
    document.querySelector("#delBtn").addEventListener("click", (e)=>{
    	if(deleteForm.boPass.value = updateForm.boPass.value)
    		deleteForm.requestSubmit();
    	else{
    		alert("비밀번호 입력");
    		updateForm.boPass.focus();
    	}
    });
</script>














