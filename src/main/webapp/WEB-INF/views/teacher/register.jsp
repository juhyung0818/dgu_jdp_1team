<%@include file="../include/tHeader.jsp"%>

<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title"></h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">
					<input type='hidden' name='subjectCode'
						value="${questionVO.subjectCode}"> <input type='hidden'
						name='examName' value="${questionVO.examName}">
				</form>



				<div align="center">
					<div class="box-header with-border">
						<h3 class="box-title">QUESTIONS</h3>
					</div>

					<table class="w3-striped">
						<tr>
							<td>QPOINT</td>
							<th>QUESTION INFOMATION</th>
							<td>ANSWER</td>
						</tr>

						<c:forEach items="${list}" var="questionVO">
							<tr>
								<td>Q${questionVO.qNumber +1}</td>
								<td>${questionVO.qInfo}<br> <br> EXAMPLES
									<ul class="w3-ul w3-border">
										<li>1) ${questionVO.ex1}</li>
										<li>2) ${questionVO.ex2}</li>
										<li>3) ${questionVO.ex3}</li>
										<li>4) ${questionVO.ex4}</li>
									</ul></td>
								<td>${questionVO.qPoint}</td>
								<td>${questionVO.answer}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<!-- /.box-body -->

				<br>
				<br>


				<div class="box-footer" align="right">
					<button type="submit" class="w3-btn w3-pink"> REMOVE </button>
				</div>


				<script>
					$(document).ready(function() {

						var formObj = $("form[role='form']");

						console.log(formObj);

						$(".btn-danger").on("click", function() {
							formObj.attr("action", "/exam/delete");
							formObj.submit();
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