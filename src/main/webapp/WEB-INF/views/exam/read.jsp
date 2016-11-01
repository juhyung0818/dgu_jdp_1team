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
					<input type='hidden' name='subjectCode' value="${questionVO.subjectCode}">
					<input type='hidden' name='examName' value="${questionVO.examName}">
				</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">EXAM NAME</label> <input
							type="text" name='title' class="form-control"
							value="${questionVO.examName}" readonly="readonly">
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

				<div class="box-footer" align="right">
					<input type="button" class="w3-btn w3-pink" value="MODIFY" onClick="self.location='/exam/register';">
					<input type="button" class="w3-btn w3-pink" value="REMOVE" onClick="self.location='/exam/delete';">
				</div>
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>

<%@include file="../include/tFooter.jsp"%>
