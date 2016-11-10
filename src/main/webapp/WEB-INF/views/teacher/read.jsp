<%@include file="../include/tHeader.jsp"%>

<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">  </h3>
				</div>
				<!-- /.box-header -->

			<div align="center">
				<div class="box-header with-border">
					<h3 class="box-title">QUESTIONS</h3>
				</div>
				
				<table class=" ">
				    
					<tr>
						<th>QUESTION NUMBERE </th>
						<th>QUESTION INFOMATION </th>
 						<td colspan="4"> EXAMPLES </td>
						<th>QPOINT </th>
						<td>ANSWER </td>
					</tr>
					
					<c:forEach items="${list}" var="questionVO">
						<tr>
							<td>${questionVO.qNumber}</td>
							<td>${questionVO.qInfo}</td>
							<td>${questionVO.ex1}</td>
							<td>${questionVO.ex2}</td>
							<td>${questionVO.ex3}</td>
							<td>${questionVO.ex4}</td>
							<td>${questionVO.qPoint}</td>
							<td>${questionVO.answer}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
<!-- /.box-body -->

<br><br>
<div class="box-footer" align="right">
	<button type="submit" class="btn btn-warning">MODIFY</button>
	<button type="submit" class="btn btn-danger">REMOVE</button>
	<button type="submit" class="btn btn-primary">LIST ALL</button>
</div>


<script>
//ë²í¼í´ë¦­ ê´ë ¨				
 $(document).ready(function(){
	
	var formObj = $("form[role='form']");
	console.log(formObj);
	
	//ìí ë¬¸ì  ìì íê¸°
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/exam/modify");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	//ìí ì­ì íê¸°
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/exam/remove");
		formObj.submit();
	});
	
	//ìí ëª©ë¡ì¼ë¡ ëìê°ê¸°
	$(".btn-primary").on("click", function(){
		self.location = "/exam/list";
	});
	
});

</script>




			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>

<%@include file="../include/tFooter.jsp"%>
