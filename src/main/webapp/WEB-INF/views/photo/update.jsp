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
<form id="file">
<input type="hidden" name="pbNum">
<table border="1">
	<tr>
		<th>번호</th>
		<td data-col="pbNum"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="pbTitle"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="pbContent"></textarea></td>
	</tr>
	<tr>
		<th>사진</th>
		<td><input type="file" name=file></td>
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
</form>
<button onclick="doUpdate()">수정</button><button onclick="doDelete()">삭제하기</button>
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
			$('textarea[name=pbContent]').val(res.pbContent);
			$('input[name=pbTitle]').val(res.pbTitle);
			$('input[name=pbNum]').val(res.pbNum);
		}
	}));
function doUpdate(){
	var file = new FormData($('#file')[0]);
	$.ajax({
		method:'POST',
		url:'/update',
		enctype: 'multipart/form-data',
		processData: false,
		contentType: false,
		data: file,
		success:function(res){
			alert(res.msg) 
			location.href='/views/photo/list';
		}
	})
}
function doDelete(){
	$.ajax({
		method:'POST',
		url:'/delete',
		data:{
			pbNum:pbNum,
		},
		success:function(res){
			alert(res.msg)
			location.href='/views/photo/list';
		}
	})
}
</script>
</body>
</html>