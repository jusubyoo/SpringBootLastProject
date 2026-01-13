<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/map.css">
<style type="text/css">
button:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="breadcumb-area" style="background-image: url(/img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>${vo.title }</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/main"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">축제 & 공연</li>
                            <li class="breadcrumb-item active" aria-current="page">${name }</li>
                            <li class="breadcrumb-item active" aria-current="page">${vo.title }</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ****** Breadcumb Area End ****** -->

    <!-- ****** Archive Area Start ****** -->
    <section class="archive-area section_padding_80">
        <div class="container">
            <div class="row">
            	<table class="table">
            		<tbody>
            			<tr>
            				<td width="30%" class="text-center" rowspan="9">
            					<img src="${vo.image1 }" style="width: 400px;height: 350px" >
            				</td>
            				<td colspan="2"><h3>${vo.title }</h3></td>
            			</tr>
            			<tr>
            				<td width="15%" class="text-center">주소</td>
            				<td width="55%">${vo.address }</td>
            			</tr>
            			<tr>
            				<td width="15%" class="text-center">이용요금</td>
            				<td width="55%">${vo.fvo.usetime }</td>
            			</tr>
            			<tr>
            				<td width="15%" class="text-center">소요시간</td>
            				<td width="55%">${vo.fvo.spendtime }</td>
            			</tr>
            			<tr>
            				<td width="15%" class="text-center">이벤트</td>
            				<td width="55%">${vo.fvo.eventstartdate }~${vo.fvo.eventenddate }</td>
            			</tr>
            			<tr>
            				<td width="15%" class="text-center">상영시간</td>
            				<td width="55%">${vo.fvo.playtime }</td>
            			</tr>
            			<tr>
            				<td width="15%" class="text-center">연령제한</td>
            				<td width="55%">${vo.fvo.agelimit }</td>
            			</tr>
            			<tr>
            				<td width="15%" class="text-center">홈페이지</td>
            				<td width="55%">${vo.fvo.eventhomepage }</td>
            			</tr>
            		</tbody>
            		
            	</table>
            	<table class="table">
            		<tbody>
            			<tr>
            				<td>${vo.fvo.msg }</td>
            			</tr>
            			<tr>
            				<td class="text-right">
            					<button type="button" class="btn btn-sm btn-danger" onclick="javascript:history.back()">목록</button>
            				</td>
            			</tr>
            		</tbody>
            	</table>
            	<table class="table"> 
            		<tbody>
            			<tr>
            				<td class="text-center">
            					<div class="map_wrap">
								    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
								
								    <div id="menu_wrap" class="bg_white">
								        <div class="option">
								            <div>
								                <form onsubmit="searchPlaces(); return false;">
								                    키워드 : <input type="text" value="${addr }&nbsp;맛집" id="keyword" size="15">
								                    <button type="submit">검색하기</button> 
								                </form>
								            </div>
								        </div>
								        <hr>
								        <ul id="placesList"></ul>
								        <div id="pagination"></div>
								    </div>
								</div>
								<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7d1d66f384fdb4c354c90e65a97ae96e&libraries=services"></script>
								<script src="/vue/seoul/map.js"></script>
            				</td>
            			</tr>
            		</tbody>
            	</table>
            </div>
        </div>
    </section>
</body>
</html>