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
<table border="1">
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
</table>
</form>
<button onclick="doInsert()">글쓰기</button>

<script>
function doInsert(){
	var file = new FormData($('#file')[0]);
	$.ajax({
		method:'POST',
		url:'/insert',
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
</script>
</body>
</html>