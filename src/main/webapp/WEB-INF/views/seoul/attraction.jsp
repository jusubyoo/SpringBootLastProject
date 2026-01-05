<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
                            <li class="breadcrumb-item active" aria-current="page">서울여행</li>
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
            				<td width="30%" class="text-center" rowspan="6">
            					<img src="${vo.image1 }" style="width: 400px;height: 350px" >
            				</td>
            				<td colspan="2"><h3>${vo.title }</h3></td>
            			</tr>
            			<tr>
            				<td width="15%" class="text-center">주소</td>
            				<td width="55%">${vo.address }</td>
            			</tr>
            			<tr>
            				<td width="15%" class="text-center">안내</td>
            				<td width="55%">${vo.avo.infocenter }</td>
            			</tr>
            			<tr>
            				<td width="15%" class="text-center">사용시간</td>
            				<td width="55%">${vo.avo.usetime }</td>
            			</tr>
            			<tr>
            				<td width="15%" class="text-center">휴무일</td>
            				<td width="55%">${vo.avo.restdate }</td>
            			</tr>
            			<tr>
            				<td width="15%" class="text-center">주차</td>
            				<td width="55%">${vo.avo.parking }</td>
            			</tr>
            		</tbody>
            	</table>
            	<table class="table">
            		<tbody>
            			<tr>
            				<td>${vo.avo.msg }</td>
            			</tr>
            			<tr>
            				<td class="text-right">
            					<button type="button" class="btn btn-sm btn-danger" onclick="javascript:history.back()">목록</button>
            				</td>
            			</tr>
            		</tbody>
            	</table>
            </div>
        </div>
    </section>
</body>
</html>