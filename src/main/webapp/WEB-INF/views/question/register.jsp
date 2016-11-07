<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@include file="../include/tHeader.jsp"%>
<head>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script>
		var questionArray = new Array();
		var questionInfo = new Object();
		
	</script>
</head>

<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
		.tg .tg-i46p{background-color:#ffccc9;color:#ffccc9}
		.tg .tg-yw4l{vertical-align:top}
</style>

<body>
	<div align="center">
		<font size="7" color="black"> 문제 출제 </font> <br> <br>
		<form ="form" method="post" class="w3-container">
			<input type='hidden' name='subjectCode' value="12312"> 
			<input type='hidden' name='examName' value="test1">


	<c:forEach var="i" begin="0" varStatus="status" end="1">

		<table class="tg">	
  		<tr>
    		<th class="tg-i46p" colspan="3" rowspan="2">
    		 <div class="form-group">
		     	번호<input class="w3-input" type="int" name="qNumber" placeholder="Enter qNumber" value='${i+1}'> <label
			   for="exampleInputEmail1"></label>
		    </div>
		    </th>
            <th class="tg-yw4l" colspan="3" rowspan="2">
             <div class="form-group">
		     <p> 배점</p><input type="int" name="qPoint" class="form-contorl" placeholder="Enter qPoint">
		     </div>
		    </th>
            <th class="tg-yw4l" colspan="9" rowspan="2">
             <div>
		     <p> 정답 </p>
		     <label class="w3-validate">1)</label>
		     <input class="w3-radio" type="radio" name="ex" value="1"> 
		     <label class="w3-validate">2)</label>
		     <input class="w3-radio" type="radio" name="ex" value="1">
		     <label class="w3-validate">3)</label>
		     <input class="w3-radio" type="radio" name="ex" value="1">
		     <label class="w3-validate">4)</label>
		     <input class="w3-radio" type="radio" name="ex" value="1">
	         </div>
	         </th>
        </tr>
        <tr>
        </tr>
        <tr>
          <td class="tg-yw4l" colspan="15" rowspan="8"> 
			<div class="form-group">
				<textarea class="form-control" name="qInfo" cols="100"  rows="20" placeholder="Enter ..."></textarea> </td>
        </tr>
        <tr>
        </tr>
  		<tr>
  		</tr>
  		<tr>
  		</tr>
  		<tr>
  		</tr>
  		<tr>
  		</tr>
  		<tr>
  		</tr>
  		<tr>
  		</tr>
  		<tr>
    	  <td class="tg-yw4l" colspan="15" rowspan="5"><p> 보기 </p>
          <ul class="w3-ul w3-border">
	       <li>1)
	        <div>
	     
		    <div class="form-group">
		    <input class="w3-input" name="ex1" rows="1" placeholder="Enter ...">
			</textarea>
		    </div>
	       </li>
	      <li>2)
		   <div class="form-group">
		   <input class="w3-input" name="ex2" rows="1" placeholder="Enter ...">
			</textarea>
		   </div>
	     </li>
	     <li>3)
		  <div class="form-group">
		  <input class="w3-input" name="ex3" rows="1" placeholder="Enter ...">
			</textarea>
		  </div>
	    </li>
	    <li>4)
	       
		<div class="form-group">
		  <input class="w3-input" name="ex4" rows="1" placeholder="Enter ...">
			</textarea>
		</div>
	  </li>
	  </ul>
	    </td>
     </tr>
     <tr>
     </tr>
     <tr>
     </tr>
     <tr>
     </tr>
     <tr>
     </tr>
    </table>
	<p> </p>
	<p> </p>
		
  </c:forEach>

	<div class="box-footer">
			<input type="submit" value="등록">
			<input type="reset" value="취소" onClick="self.location='/exam/managementExam';">
	</div>

	</form>
</div>

</body>
		
		
<%@include file="../include/tFooter.jsp"%>