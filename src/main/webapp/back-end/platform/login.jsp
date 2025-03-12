<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.admin.model.*"%>
<%
AdminService adminSvc = new AdminService();
List<AdminVO> adminList = adminSvc.getAll();
pageContext.setAttribute("adminList", adminList);
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>平台管理登入</title>
<!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/admin_login.css" /> -->
<style>
* {
	box-sizing: border-box;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 80vh;
	background-color: #e4c1c1;
	font-family: Arial, sans-serif;
}

.login-container {
	background: rgba(255, 255, 255, 0.5); /* 設定白色，透明度 0.8 */
	padding: 20px;
	border-radius: 15px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	width: 400px;
}

.login-container h2 {
	text-align: center;
	margin-bottom: 20px;
}

.input-group {
	margin-bottom: 15px;
}

.input-group label {
	display: block;
	margin-bottom: 5px;
}

.input-group input {
	width: 95%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 20px;
}

.login-btn {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	border: none;
	color: white;
	border-radius: 10px;
	cursor: pointer;
}

.login-btn:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="login-container">
		<h2>寵愛牠平台方管理系統登入</h2>

		<form id="loginForm"
			action="${pageContext.request.contextPath}/LoginHandler"
			method="post">
			<div class="input-group">
				<label for="username">帳號</label>
				<!-- required為必填屬性 -->
				<input type="text" id="username" value="" name="account" required />
			</div>
			<div class="input-group">
				<label for="password">密碼</label> <input type="password"
					id="password" name="password" value="" required />
			</div>
			<button type="submit" value="  ok   " class="login-btn">登入</button>
		</form>
	</div>

	<script
		src="${pageContext.request.contextPath}/resource/vendors/jquery/jquery-3.7.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resource/js/login.js"></script>

</body>
</html>
