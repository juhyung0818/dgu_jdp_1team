<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<html>
	<head>
		<style type="text/css"> 
			h1 {background:yellow;}
			p {color:black;}
        </style>


<meta charset="euc-kr">
<title>CSS 속성</title>
<style type="text/css">
    body {
        background-color: #e7e7e7;
    }
    span {
        width: 300px; height: 150px;
        border: 3px solid; padding: 5px;
        display: inline-block
        
    }
    #span1 {background-color: #33CCFF;}
    #span2 {background-color: #33CCFF;}
    
</style>
	</head>
	
	<center>
	<font size="7" color="hotpink"> 순성닷컴 </font> 
	<hr color="hotpink"> 
	<br> <br>
<body>
<center>
	<br>
	<br>
	<br>
	<br>
	
    <span id="span1">
     <legend> 학생 로그인
       <ul>
      <li>
        <label for="id">ID:</label>
        <input type="text" name="id" id="id" value="" />
      </li>
      <li>
        <label for="password">PW:</label>
        <input type="text" name="pw" id="pw" value="" />
      </li>
      <p>
        <input type="submit" value="로그인" />
        <input type="submit" value="회원가입" />
        
      </p>
     
    </ul>
    </legend>
    </span>
    &nbsp 
    &nbsp
    &nbsp
    &nbsp
    &nbsp
    &nbsp
    &nbsp
    &nbsp
    &nbsp
    &nbsp
    &nbsp
    &nbsp
    &nbsp
    
    <span id="span2">
    
     <legend> 선생님 로그인
    <ul>
      <li>
        <label for="id">ID:</label>
        <input type="text" name="id" id="id" value="" />
      </li>
      <li>
        <label for="password">PW:</label>
        <input type="text" name="pw" id="pw" value="" />
      </li>
      <p>
        <input type="submit" value="로그인" />
        <input type="submit" value="회원가입" />
        
      </p>
     
    </ul>
    
    </legend>
    </span>
    </br>
    </br>
    </br>
    </br>
    </center>
</body>
</html>
	
