<%@include file="../include/tHeader.jsp"%>

<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ EXAM</h3>
				</div>
				<!-- /.box-header -->

			<div align="center">
				<div class="box-header with-border">
					<h3 class="box-title">QUESTION LIST</h3>
				</div>

				<table class="table table-bordered">
					<tr>
						<th>EXAM NAME</th>
						<th>QUESTION NUMBERE</th>
						<th>QUESTION INFOMATION</th>
					</tr>
					
					<c:forEach items="${list}" var="questionVO">
						<tr>
							<td>${questionVO.examName} </a></td>
							<td>${questionVO.qNumber}</td>
							<td>${questionVO.qInfo}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
<!-- /.box-body -->

<div class="box-footer">
	<button type="submit" class="btn btn-warning">MODIFY</button>
	<button type="submit" class="btn btn-danger">REMOVE</button>
	<button type="submit" class="btn btn-primary">LIST ALL</button>
</div>


<script>
//ë²í¼í´ë¦­ ê´ë ¨				
/* $(document).ready(function(){
	
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
	
}); */

</script>




			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>

<%@include file="../include/tFooter.jsp"%>
