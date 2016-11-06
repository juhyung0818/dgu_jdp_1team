<%@include file="../include/sHeader.jsp"%>

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

				<div align="center">
					<div class="box-header with-border">
						<h3 class="box-title">QUESTIONS</h3>
					</div>

					<table class="w3-striped">
						<tr>
							<td>QPOINT</td>
							<th>QUESTION INFOMATION</th>
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
							</tr>
						</c:forEach>
					</table>
				</div>
				<!-- /.box-body -->
				<br>
				<br>
				<div class="box-footer">
					<br>
					<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge">
						제출
					</button>
					<button type="reset" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge">
						취소
					</button>
				</div>
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->
	</div>
	<!-- /.row -->
</section>

<%@include file="../include/sFooter.jsp"%>