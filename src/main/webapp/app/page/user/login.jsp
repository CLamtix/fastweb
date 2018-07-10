<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>登陆</title>
<link rel="stylesheet" type="text/css" href="app/css/styles.css">
</head>

<body>
	<div class="wrapper">

		<div class="container">
			<h1>Welcome</h1>
			<form class="form" action="user/login" method="post" name="user">
				<input type="input" placeholder="用户名" id="loginName" name="loginName">
				<input type="password" placeholder="密码" id="password" name="password">
				<button type="submit" id="">登录</button>
			</form>
		</div>

	</div>

	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
</script>
</body>
</html>
