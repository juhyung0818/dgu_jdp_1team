<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>tab example</title>
<style>
#container {
	width: 960px;
	margin: 0 auto;
	text-align: center;
}

.tab {
	list-style: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
}
/* Float the list items side by side */
.tab li {
	float: left;
}
/* Style the links inside the list items */
.tab li a {
	display: inline-block;
	color: #000;
	text-align: center;
	text-decoration: none;
	padding: 14px 88px;
	font-size: 17px;
	transition: 0.3s;
}
/* Style the tab content */
.tabcontent {
	display: none;
	background-color: #e6e6fa;
	padding: 25px;
	color: black;
}

ul.tab li.current {
	background-color: #ff8c00;
	color: #222;
}

.tabcontent.current {
	display: block;
}

.tg {
	border-collapse: collapse;
	border-spacing: 0;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg .tg-yw4l {
	vertical-align: top
}

h1 {
	color: #333;
	font-family: arial, sans-serif;
	margin: 1em auto;
	width: 80%;
}

.tabordion {
	color: #333;
	display: block;
	font-family: arial, sans-serif;
	margin: auto;
	position: relative;
	width: 80%;
}

.tabordion input[name="sections"] {
	left: -9999px;
	position: absolute;
	top: -9999px;
}

.tabordion section {
	display: block;
}

.tabordion section label {
	background: #ccc;
	border: 1px solid #fff;
	cursor: pointer;
	display: block;
	font-size: 1.2em;
	font-weight: bold;
	padding: 15px 20px;
	position: relative;
	width: 180px;
	z-index: 100;
}

.tabordion section article {
	display: none;
	left: 230px;
	min-width: 300px;
	padding: 0 0 0 21px;
	position: absolute;
	top: 0;
}

.tabordion section article:after {
	background-color: #ccc;
	bottom: 0;
	content: "";
	display: block;
	left: -229px;
	position: absolute;
	top: 0;
	width: 220px;
	z-index: 1;
}

.tabordion input[name="sections"]:checked+label {
	background: #eee;
	color: #bbb;
}

.tabordion input[name="sections"]:checked ~ article {
	display: block;
}

@media ( max-width : 533px) {
	h1 {
		width: 100%;
	}
	.tabordion {
		width: 100%;
	}
	.tabordion section label {
		font-size: 1em;
		width: 160px;
	}
	.tabordion section article {
		left: 200px;
		min-width: 270px;
	}
	.tabordion section article:after {
		background-color: #ccc;
		bottom: 0;
		content: "";
		display: block;
		left: -199px;
		position: absolute;
		top: 0;
		width: 200px;
	}
}

@media ( max-width : 768px) {
	h1 {
		width: 96%;
	}
	.tabordion {
		width: 96%;
	}
}

@media ( min-width : 1366px) {
	h1 {
		width: 70%;
	}
	.tabordion {
		width: 70%;
	}
}
</style>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
	<div id="container">
		<h2>학식세끼</h2>

		<ul class="tab">
			<li class="current" data-tab="tab1"><a href="#">식단보기</a></li>
			<li data-tab="tab2"><a href="#">메뉴추가</a></li>
			<li data-tab="tab3"><a href="#">평가보기</a></li>
			<li data-tab="tab4"><a href="#">소리함</a></li>
		</ul>

		<div id="tab1" class="tabcontent current">

			<div class="tabordion">
				<section id="section1">
					<input type="radio" name="sections" id="option1" checked> <label
						for="option1">조식</label>
					<article>
						<p>조식</p>
					</article>
				</section>
				<section id="section2">
					<input type="radio" name="sections" id="option2"> <label
						for="option2">중식</label>
					<article>
						<p>중식</p>
					</article>
				</section>
				<section id="section3">
					<input type="radio" name="sections" id="option3"> <label
						for="option3">석식</label>
					<article>
						<p>석식</p>
					</article>
				</section>


			</div>

		</div>

		<div id="tab2" class="tabcontent">

			<div align="center">
				<table class="tg">
					<tr>
						<th class="tg-031e" colspan="4" rowspan="4">식당</th>
						<th class="tg-031e" colspan="4" rowspan="4">이름</th>
						<th class="tg-031e" colspan="4" rowspan="4">사진</th>
						<th class="tg-031e" colspan="4" rowspan="4">가격</th>
					</tr>
					<tr>
					</tr>
					<tr>
					</tr>
					<tr>
					</tr>
					<tr>
						<td class="tg-031e" colspan="4" rowspan="4"><input
							class="w3-input" name="cafeteria" rows="1"
							placeholder="Enter Cafeteria name"></td>
						<td class="tg-031e" colspan="4" rowspan="4"><input
							class="w3-input" name="menuname" rows="1"
							placeholder="Enter Menu name"></td>
						<td class="tg-031e" colspan="4" rowspan="4"><input
							class="w3-input" name="photo" rows="1" placeholder="Put photo"></td>
						<td class="tg-031e" colspan="4" rowspan="4"><input
							class="w3-input" name="price" rows="1" placeholder="Enter Price"></td>
					</tr>
					<tr>
					</tr>
					<tr>
					</tr>
					<tr>
					</tr>
				</table>
				<div>
					<br>
					<button id="complete"
						class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge">
						COMPLETE</button>
					<button type="reset"
						class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge">
						CANCLE</button>
				</div>
			</div>
		</div>

		<div id="tab3" class="tabcontent">
			<h3>평가보기</h3>
			<p></p>
		</div>

		<div id="tab4" class="tabcontent">
			<h3>소리함</h3>
			<p></p>
		</div>
	</div>

	<script>
		$(function() {
			$('ul.tab li').click(function() {
				var activeTab = $(this).attr('data-tab');
				$('ul.tab li').removeClass('current');
				$('.tabcontent').removeClass('current');
				$(this).addClass('current');
				$('#' + activeTab).addClass('current');
			})
		});
	</script>
</body>
</html>