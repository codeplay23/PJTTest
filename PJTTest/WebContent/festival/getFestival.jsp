<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a6419e542017d8fd315556f745f29fcf"></script>
	
	<script type="text/javascript">
	
		var map = null;
		var mapx = ${festival.mapx}; // 경도
		var mapy = ${festival.mapy};	//위도
		
$(function() {
			
			var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
			var options = { //지도를 생성할 때 필요한 기본 옵션
				center: new daum.maps.LatLng(mapy, mapx), //지도의 중심좌표.
				level: 3 //지도의 레벨(확대, 축소 정도)
			};
			
			var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴

		});
	
		</script>		
	
</head>
<body>
축제명<input type="text" value= "${festival.title }">
<br/>
<br/>
개최장소<input type="text" value="${festival.addr1 } + ${festival.addr2}">
<br/>
<br/>
<%-- 축제시작일자<input type="text" value="${festival.eventstartdate }">
<br/>
<br/>
축제종료일자<input type="text" value="${festival.evnetenddate }">
<br/>
<br/> --%>
축제내용<input type="text" value="">
<br/>
<br/>
시작일<input type="text" value="${festival.eventstartdate }">
<br/>
<br/>
종료일<input type="text" value="${festival.eventenddate }">
<br/>
<br/>
이미지 <img src="${festival.firstimage }">
<br/>
<br/>
경도<input type="text" value="${festival.mapx }">
<br/>
<br/>


<div id="map" style="width:100%;height:350px;"></div>
	<p>

<input type="button" value="등록"/>

</body>
</html>