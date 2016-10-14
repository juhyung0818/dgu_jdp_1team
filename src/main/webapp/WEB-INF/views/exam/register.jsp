<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<form fole="form" method="post">

	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1"> subjectCode </label>
			<input type="text" name='subjectCode' class="form-contorl" placeholder="Enter subjectCode">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">examName</label>
			<textarea class="form-control" name="content" rows="3" placeholder="Enter ..."></textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">qNumber</label>
			<input type="text" name="qNumber" class="form-control" placeholder="Enter qNumber">
		</div>
		<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1"> qInfo </label>
			<textarea class="form-control" name="qInfo" rows="3" placeholder="Enter ..."></textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">qPoint</label>
			<input type="text" name='qPoint' class="form-contorl" placeholder="Enter qPoint">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">answer</label>
			<input type="text" name="answer" class="form-control" placeholder="Enter answer">
		</div>
	</div>
	<div class="box-footer">
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
</form>

