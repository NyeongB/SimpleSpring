<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<html>
<head>
<title>Home</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/style.css" />
</head>
<body>
	<h1>Hello world!</h1>
	<P>The time on the server is ${serverTime}.</P>
	
	<a href="${pageContext.request.contextPath }">HomeController</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/script.js"></script>
</body>
</html>
