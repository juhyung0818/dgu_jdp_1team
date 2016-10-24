<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<head>
		<style type="text/css"> 
			h1 {background:yellow;}
			p {color:black;}
        </style>
	</head>
	
	<center>
	<font size="7" color="hotpink"> 문제 출제 </font> 
	<hr color="hotpink"> 
	<br> <br>

	<form fole="form" method="post">

	<div class="box-body">
		<div class="form-group">
			<p> subjectCode
			<input type="int" name="subjectCode" class="form-contorl" placeholder="Enter subjectCode" border-color="pink">
			 </p>
		</div>

		<div class="form-group">
			<p> examName
			<textarea class="form-control" name="examName" rows="3" placeholder="Enter ..."></textarea>
			</p>
		</div>

		<div class="form-group">
			<label for="exampleInputEmail1">qNumber</label>
			<input type="int" name="qNumber" class="form-control" placeholder="Enter qNumber">
		</div>

		<div class="box-body">
		<div class="form-group">
			<p> qInfo
			<textarea class="form-control" name="qInfo" rows="3" placeholder="Enter ..."></textarea>
			</p>
		</div>

		<div class="form-group">
			<p> qPoint
			<input type="int" name="qPoint" class="form-contorl" placeholder="Enter qPoint">
			</p>
		</div>
		<div class="form-group">
			<p> answer
			<input type="int" name="answer" class="form-control" placeholder="Enter answer">
			</p>
		</div>

	</div>

	<div class="box-footer">
		<input type="submit" value="등록">
    <input type="reset" value="취소">
	</div>

	</form>
</center>
