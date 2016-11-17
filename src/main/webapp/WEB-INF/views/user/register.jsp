<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<title>순성닷컴</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<style>

body, h1 {
	font-family: "Raleway", Arial, sans-serif
}

h1 {
	letter-spacing: 10px
}

.w3-row-padding img {
	margin-bottom: 12px
}

.w3-row-padding {
	margin-bottom: 128px
}

.w3-myfont {
	font-family: "Comic Sans MS", cursive, sans-serif;
}

.member {
 font-size: 50px;
 text-shadow: 0 0 10px #666;
 color: #fff;
 margin: 0 auto;
 text-align: center;
 text-transform: capitalize;
 font-family: Arial, sans-serif
 font-style: italic;
}
body {
 font-family: Arial, sans-serif
 font-size: 12px;
}
.form {
 width: 700px;
 height: 450px;
 border-radius: 25px;
 border: 5px double #999;
 margin: 30px auto;
}
.form2 {
 width: 600px;
 min-width: 320px;
 height: 600px;
 margin: 60px auto;
 margin-left:20px;
}
.form3 {
 float: left;
 /*   background:#f00;  */
}
.form3 label {
 width: 800px;
 height: 70px;
 /*  display: block; */
 float: left;
}
.form4 {
 padding: 0px 0px 0px 70px;
}
#wrap {
 width: 600px;
 height: 500px;
 margin: 0 auto;
}
.clear {
 clear: both;
}


input[type="button"] {
 height: 30px;
 background: pink;
 border-radius: 5px; 
/*  width: 140px; */
 font-family:Arial, sans-serif
 margin-top:10px;
 margin-left:10px;
 margin-right:20px;
}

</style>
<body>

<div class="w3-content" style="max-width: 1500px">

	<!-- Header -->
	<header class="w3-panel w3-center w3-opacity">
	<div class="w3-panel w3-pink">
		<h1 class="w3-opacity"> 순성닷컴 </h1>
		</div>
	</header>

</div>

<!-- <form action="/user/loginPost" method="post"> -->
<form id='my-form' method="post"> 
  
  <div id="wrap">
   <h1 class="member">member register</h1>
   
   <div class="form">
    <div class="form2">
     <div class="form3">
      <p> 이름 입력 : <input name= "uname" class="form-control" reqiored autofocus placeholder= "Enter name"></p>
     <p> 아이디 입력 : <input name= "uid" class="form-contorl"  required placeholder="Enter ID">
         <button id="check" class ="btn-check">ID 중복체크</button>

     <p> 비밀번호 입력:<input name="upw" name="pass" type="password" required class="form-contorl" maxlength="12" pattern={"A-Za-z0-9"} placeholder="Enter PWD">
         (영어와 숫자가 혼합 된 6~12자리의 비밀번호)</p>
     <p> 비밀번호 재입력 :
     	<input id="pass-check" required  type="password" class="form-control" placeholder="Enter PWD">  
         <input type="submit" value="확인" >                   
     <p> 사용자 선택 :
                     
		     <input class="w3-radio" type="radio" name="flag" value="1">  선생님
		    <input class="w3-radio" type="radio" name="flag" value="0"> 학생
	</p>	
    
      <div align=center > 
      			<button>등록</button>
				<input type="reset" value="취소" onClick="self.location='/user/login'">
		</div>
     </div>
    </div>
   </div>
  </div>

 </form>
    

   
   
 <script>


window.onload=function(){
	document.getElementById('my-form').onsubmit=function(){
		var pass=document.getElementById('pass').value;
		var passCheck=document.getElementById('pass-check').value;
	     
		if (pass==""||passCheck==""){
			alert('비밀번호를 입력하세요');
		}
		else if(pass==passCheck){
			alert('비밀번호가 일치합니다');
			return true;}
		else{
			alert('비밀번호가 일치하지 않습니다. 다시 입력 해 주세요');
		}
	}
}

$(document).ready(function() {

	var formObj = $("form[role='form']");

	console.log(formObj);

	$(".btn-check").on("click", function() {
		formObj.attr("action", "/user/check");
		formObj.submit();
	});

});


</script>  
</body>
</html>