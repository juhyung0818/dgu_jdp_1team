<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="include/tHeader.jsp"%>


<!DOCTYPE html>
<html>
<body>

	<h1>My First Google Map</h1>

	<div id="map" style="width: 400px; height: 400px; background: yellow"></div>

	<script>
		function myMap() {
			var mapOptions = {
				center : new google.maps.LatLng(51.5, -0.12),
				zoom : 10,
				mapTypeId : google.maps.MapTypeId.HYBRID
			}
			var map = new google.maps.Map(document.getElementById("map"),
					mapOptions);
		}
	</script>

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script>

</body>
</html>


<%@include file="include/tFooter.jsp"%>