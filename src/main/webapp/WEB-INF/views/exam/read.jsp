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

<form role="form" method="post">

	<input type='hidden' name='bno' value="${questionVO.examName}">

</form>

<div class="box-body">
	<div class="form-group">
		<label for="exampleInputEmail1">EXAM NAME</label> <input type="text"
			name='title' class="form-control" value="${questionVO.examName}"
			readonly="readonly">
	</div>
	<div class="form-group">
		<label for="exampleInputPassword1">QUESTIONS</label>
		<textarea class="form-control" name="content" rows="3"
			readonly="readonly">${questionVO.content}</textarea>
	</div>
	<div class="form-group">
		<label for="exampleInputEmail1">qNumber</label> <input type="text"
			name="writer" class="form-control" value="${questionVO.qNumber}"
			readonly="readonly">
	</div>
</div>
<!-- /.box-body -->

<div class="box-footer">
	<button type="submit" class="btn btn-warning">MODIFY</button>
	<button type="submit" class="btn btn-danger">REMOVE</button>
	<button type="submit" class="btn btn-primary">LIST ALL</button>
</div>


<script>
//버튼클릭 관련				
/* $(document).ready(function(){
	
	var formObj = $("form[role='form']");
	console.log(formObj);
	
	//시험 문제 수정하기
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/exam/modify");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	//시험 삭제하기
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/exam/remove");
		formObj.submit();
	});
	
	//시험 목록으로 돌아가기
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
