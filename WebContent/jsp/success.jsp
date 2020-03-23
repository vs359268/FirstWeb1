<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<meta name="keywords" content="taped login form Widget a Flat Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<title>用户登录</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Meta tag Keywords -->
<link rel="stylesheet" href="../static/css/style.css" type="text/css" media="all" /><!-- Style-CSS -->
<link rel="stylesheet" href="../static/css/font-awesome.css" type="text/css" media="all" />
<link href="//fonts.googleapis.com/css?family=Snippet" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Barlow" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">
<title>登录成功</title>
<script type="text/javascript" src="${ctx}/static/js/jquery-2.2.4.js"></script>
<script type="text/javascript">

	$(function () {
		
	
	});
	
</script>
</head>
<body data-vide-bg="../static/video/ship">
<section class="login-maintop">
	<div class="login-main">
		<header><h1>taped login form</h1></header>
		<div class="login-form">
			<h2>登录成功;<a href="${ctx}/LoginServlet?action=logout">点击退出</a><br><br></h2>
			<form action="${ctx }/UploadServlet" method="post" enctype="multipart/form-data">
				<input type="file" name="file" />
				<input type="submit" value="上传" >
			</form>
			
			<div class="login-password">
				<span><a href="#">forgot password</a></span>
			</div>
			<div class="login-input">
			
			</div>
			<div class="social-icons">
				<ul>
					<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
					<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
				</ul>
				
			</div>
		</div>
		<!--footer-->
		<div class="footer">
			<p>&copy; 2019 Taped Login Form. All rights reserved | Design by <a href="http://w3layouts.com">SunHao</a></p>
		</div>
		<!--//footer-->
	</div>
</section>
<script type="text/javascript" src="../static/js/jquery-2.1.4.min.js"></script>
<script src="../static/js/jquery.vide.min.js"></script>
</body>
</html>