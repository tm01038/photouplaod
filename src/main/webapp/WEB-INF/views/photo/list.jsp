<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th data-col="pbNum">번호</th>
				<th data-col="pbTitle">제목</th>
				<th data-col="pbImgPath">사진</th>
				<th data-col="credat">작성일</th>
				
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<div id="block"></div>
	<a onclick="location.href='/views/photo/insert'"><button>글쓰기</button></a>
	<script>
	$('document').ready(page());
	function page(num){
		if(isNaN(num)){
			num=1;
		}
		if(num<1){
			num=1;
		}
		var startBlock = ((Math.floor((num-1)/10))*10+1);
		var endBlock = startBlock+9;
		$.ajax({
			url : '/list',
			method : 'GET',
			data:{page:num},
			success : function(res) {
				var html ='';
				for ( var photo of res.result) {
					html += '<tr onclick=goUpdate('+photo.pbNum+')>';
					$('th[data-col]').each(function(idx, th) {
						var col = th.getAttribute('data-col');
						html += '<td>'; 
						if(col=='pbImgPath' && photo[col]!=null){
						html +='<img src="/resources/img/'+photo[col]+'" onerror="this.style.display='+"'none'"+'"  style="width:50px">'
						}else if(photo[col]!=null){
						html += photo[col];	  
						}
					
						html += '</td>';
					});
					html += '</tr>';
				}
				$('tbody').html(html);
				var page = '';
				var totalCnt = Math.ceil(res.totalCnt/10);
				page +='<a onclick="page('+1+')"> ☜ </a>';
				page +='<a onclick="page('+(num-1)+')"> ◀ </a>';
				if(endBlock>=totalCnt){
					endBlock=totalCnt;
				}
				for(var i = startBlock; i<=endBlock; i++){
					page +=' <a onclick="page('+i+')">'+i+'</a> ';
				}
				if(num>=totalCnt){
					page +='<a onclick="page('+(endBlock)+')"> ▶ </a>';
				}else{
					page +='<a onclick="page('+(num+1)+')"> ▶ </a>';
				}
				page +='<a onclick="page('+totalCnt+')"> ☞ </a>';
				$('#block').html(page);
			}
		});
	}
	function goUpdate(pbNum){
		location.href='/views/photo/view?pbNum='+pbNum;
	}
	</script>

</body>
</html>