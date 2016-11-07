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
 width: 420px;
 height: 280px;
 border-radius: 25px;
 border: 5px double #999;
 margin: 30px auto;
}
.form2 {
 width: 380px;
 min-width: 320px;
 height: 200px;
 margin: 60px auto;
 margin-left:20px;
}
.form3 {
 float: left;
 /*   background:#f00;  */
}
.form3 label {
 width: 100px;
 height: 20px;
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

input[type="submit"] {
 float: left;
 /*  display:block; */
 height: 50px;
 background: #FFBB00;
 border-radius: 5px;
 border: none;
 font-family: Arial, sans-serif
}
.submit 1 {height:20px;}

input[type="button"] {
 height: 30px;
 background: gray;
 border-radius: 5px; 
/*  width: 140px; */
 font-family:Arial, sans-serif
 margin-top:10px;
 margin-left:100px;
 margin-right:20px;
}
input[type="checkbox"] {
 margin-top:20px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    position: relative;
    background-color: #fefefe;
    margin: auto;
    padding: 0;
    border: 1px solid #888;
    width: 60%;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
    -webkit-animation-name: animatetop;
    -webkit-animation-duration: 0.4s;
    animation-name: animatetop;
    animation-duration: 0.4s
}

/* Add Animation */
@-webkit-keyframes animatetop {
    from {top:-300px; opacity:0}
    to {top:0; opacity:1}
}

@keyframes animatetop {
    from {top:-300px; opacity:0}
    to {top:0; opacity:1}
}

/* The Close Button */
.close {
    color: white;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

.modal-header {
    padding: 2px 16px;
    background-color: pink;
    color: white;
}

.modal-body {padding: 2px 16px;}

.modal-footer {
    padding: 2px 16px;
    background-color: pink;
    color: white;
}
</style>

<body>


<!-- !PAGE CONTENT! -->
<div class="w3-content" style="max-width: 1500px">

	<!-- Header -->
	<header class="w3-panel w3-center w3-opacity">
	<div class="w3-panel w3-pink">
		<h1 class="w3-opacity"> 순성닷컴 </h1>
		</div>
	</header>

</div>
   
<form>
  <div id="my-form">
  <div id="wrap">
   <h1 class="member">member login</h1>
   <div class="form">
    <div class="form2">
     <div class="form3">
      <label for="user">아이디</label><input type="text" id="user">
      <div class="clear"></div>
      <label for="user">비밀번호</label><input type="password" id="user">
     </div>
     <input type="submit"  value="로그인하기">
     <div class="clear"></div>
     <div class="form4">
      <label><input type="checkbox">아이디저장</label> 
      <div class="clear"></div>
      <label><input type="button" id="myBtn" value="회원가입"></label>

     </div>
    </div>
   </div>
  </div>
<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->

  <div class="modal-content">
    <div class="modal-header">
      <span class="close">X</span>
      <h2>회원가입</h2>
    </div>
    <div class="modal-body">
     <p> 이름 입력 : <input id= "name" class="form-control" placeholder= "Enter name"></p>
     <p> 아이디 입력 : <input id="ID" class="form-contorl" placeholder="Enter ID">
         <button>ID 중복체크</button>

     <p> 비밀번호 입력:<input id="pass" name="pass" type="password" class="form-contorl" placeholder="Enter PWD">
         (영어와 숫자가 혼합 된 6~12자리의 비밀번호)</p>
     <p> 비밀번호 확인 :<input id="pass-check"   type="password" class="form-control" placeholder="Enter PWD">  
         <button>확인</button>                     
     <p> 사용자 선택 :
		     <input class="w3-radio" type="radio" name="ex" value="1">

                     <label class="w3-validate">선생님</label>
		    
		     <input class="w3-radio" type="radio" name="ex" value="1">
                      <label class="w3-validate">학생</label>
    </p>
    </div>             
    <div class="modal-footer">
      <div class="box-footer">
      			<button>등록</button>
				<input type="reset" value="취소" onClick="self.location='/test/login?pass=">
	  </div>
    </div>
  </div>

</div>
</div>
 </form>
<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

window.onload=function(){
	document.getElementById('my-form').onsubmit=function(){
	var pass=document.getElementById('pass').value;
	var passCheck=document.getElementById('pass-check').value;

	if(pass==passCheck){
	alert('성공');}
	else{
	alert('실패');
	return false;}
	}
}
</script>     

</body>

</html>

