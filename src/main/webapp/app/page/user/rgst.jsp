<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="app/css/styles.css">
</head>

<body>

	<div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>
			<form class="form" action="user/rgst" method="post" name="user">
				<input type="input" placeholder="用户名" id="loginName" name="loginName">
				<input type="password" placeholder="密码" id="password" name="password">
				<button type="submit" id="">注册</button>
			</form>
		</div>
	</div>

</body>
</html>
