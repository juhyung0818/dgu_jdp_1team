<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function chkMbId() {
		$.ajax({
			url : "/user/check",
			type : "post",
			data : {
				uid : $("#uid").val()
			},
			dataType : "json",
			success : function(data) {

				$(
						"<div style='text-align:center;'>" + data.resultMsg
								+ "</div>").dialog({
					modal : true,
					resizable : false,
					buttons : [ {
						text : "확인",
						click : function() {
							$(this).dialog("close");
						}
					} ]
				});
				$(".ui-dialog-titlebar").hide();

				if (data.result == "success") {

				} else {

				}
			}
		});
	}
</script>
</head>
<body>
	<form method="post" action="/user/register">
		회원가입<br /> <br />
		<div>
			<label for="uid" style="display: inline-block; width: 100px;">회원아이디</label>
			<input type="text" name="uid" id="uid" /> <input type="button"
				value="중복 체크" onclick="chkMbId();">
		</div>
		<div>
			<label for="uname" style="display: inline-block; width: 100px;">회원명</label>
			<span><input type="text" name="uname" id="uName" /></span>
		</div>
		<div>
			<label for="upw" style="display: inline-block; width: 100px;">회원패스워드</label>
			<span><input type="text" name="upw" id="upw" /></span>
		</div>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>
