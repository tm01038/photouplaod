<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<td data-col="pbNum"><input type="hidden" id="pbNum"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td data-col="pbTitle"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td data-col="pbContent"></td>
	</tr>
	<tr>
		<th>사진이름</th>
		<td data-col="pbImgPath"></td>
	</tr>
	<tr>
		<th>작성일</th>
		<td data-col="credat"></td>
	</tr>
	<tr>
		<th>작성시간</th>
		<td data-col="cretim"></td>
	</tr>
</table>
<a onclick="location.href='/views/photo/update?pbNum=${param.pbNum}'"><button>수정하기</button></a>
<script>
var pbNum = ${param.pbNum};
	$('document').ready($.ajax({
		method:'get',
		url:'/select',
		data:{
			'pbNum':pbNum
		},
		success:function(res){
			$('td[data-col]').each(function(idx,td){
				var col = td.getAttribute('data-col');
				$('td[data-col='+col+']').text(res[col]);
			})
		}
	}));
</script>
</body>
</html>