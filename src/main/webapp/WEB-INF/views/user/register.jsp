<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/tHeader.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style type="text/css">
label {
	display: none;
}

input {
	height: 30px;
}

fieldset {
	width: 200pt;
	border: 3;
	border-color: pink;
}
</style>

	<center>
		<h1>User Register</h1>
		<fieldset>
			<form action="/user/register" method="post">
				<table>
					<tr>
						<th>ID:</th>
						<td>
							<input type="text" name="uid" id="uid" required>
							<button onclick="checkID()">ID중복확인</button>
						
						</td>
					</tr>
					<tr>
						<td colspan="2">
							결과 :
						<script type="text/javascript">
							if("${idCheck}"==true)
							{
								document.write("사용가능합니다.");
							}
							else
							{
								document.write("이미 사용중입니다.");
							}
						</script> 
							<!-- 
							<c:set var="id_check" value="false"></c:set>
							
							<c:choose>
								<c:when test="${idCheck eq 'true'}">
									사용가능합니다.
								</c:when>
								<c:when test="${idCheck eq 'false'}">
									이미 사용중입니다.
								</c:when>
							</c:choose>
							 -->
						</td>
					</tr>
					<tr>
						<th>PW:</th>
						<td colspan="2"><input type="text" name="upw" required><br></td>
					</tr>
					<tr>
						<th>Name:</th>
						<td colspan="2"><input type="text" name="uname" required><br></td>
					</tr>
					<tr>
						<th>직업:</th>
						<td colspan="2"><input type="radio" name="lfa" value="1"
							required> 선생님 <input type="radio" name="gender" value="0">
							학생</td>
					</tr>
				</table>
				<input type="submit"
					class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"
					value="OK"> <a href='/'> <input type="button"
					class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"
					value="BACK">
				</a>
			</form>
		</fieldset>

	</center>
	
<script>


function checkID()
{
	var id = $('#uid').val();
    // ajax 실행
    $.ajax({
        type : 'POST',
        url : '/user/idCheck',
        data:
        {
            id: id
        },
    }); // end ajax
}

</script>
<%@include file="../include/tFooter.jsp"%>

