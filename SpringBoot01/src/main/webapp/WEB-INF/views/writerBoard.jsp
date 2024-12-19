<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Forty by HTML5 UP</title>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/board.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>
<body>
	<div id="board">
	<h1>게시글 작성페이지</h1>
		<%--게시글 작성 form태그 --%>
		<%--데이터 전송에 필요한 form태그 3요소!! --%>
		
		<!-- HTTP : hyper "text" transfer protocol
		
		MIME : 파일을 문자로 바꿔서 전송하자.
		
		텍스트 이외의 파일 보낼 떄 : 
		>>전송방식이 post로 한정  >>form태그에 메소드 포스트로 지정해줘야 함
		>>파일 전송시에, 인코딩되지 않도록 설정
		form 태그의 endtype을 "multipart/form-data"로 지정해야 한다. 
		
		
		  -->
		
		<form action="write" method="post" enctype="multipart/form-data">
			<table id="list">
				<tr>
					<td>제목</td>
					<td><input name="title" type="text"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<!-- 태그 수정 불가 코드
					readonly : 클릭은 되는데 커서가 안 됨
					disabled: 클릭도 안 됨. : 인풋 태그에서 절대 사용x 데이터 전송도 막아버림.
					 -->
					<td><input readonly value="${user.email}" name="writer" type="text"></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input name="file" type="file"></td>
				</tr>
				<tr>
					<td colspan="2">내용</td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="content" rows="10" style="resize: none;"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="reset" value="초기화"> <input
						type="submit" value="작성하기"></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>
</body>
</html>