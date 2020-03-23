<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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
<script type="text/javascript" src="${ctx}/static/js/jquery.js"></script>
<script type="text/javascript">
$(function () {
    $('#btn').click(function () {
        var count = 60;
        var countdown = setInterval(CountDown, 500);
        function CountDown() {
            $("#btn").attr("disabled", true);
            $("#btn").val("Please wait " + count + " seconds!");
            if (count == 0) {
                $("#btn").val("获取验证码").removeAttr("disabled");
                clearInterval(countdown);
            }
            count--;
        }
    })
});
</script>
<script type="text/javascript" src="${ctx}/static/js/jquery-2.2.4.js"></script>
<script type="text/javascript">

	var numRandom=431515;
	
	$(function () {
		
		$("#btn").click(function () {
			
			var mobile = $("#mobile").val();
			if (!mobile) {
				alert("请填写正确的手机号码.");
				return ;
			}
			numRandom = numRandom(6);
			$.ajax({
		        url:'http://v.juhe.cn/sms/send',
		        type:'POST',
		        data:{
		        	mobile: mobile,
		        	tpl_id:'127192',
		        	tpl_value:'%23code%23%3d'+numRandom,
		        	key:'68cb00cf480a9e4c22d5879fb1cd181b',
		        },
		        dataType:'jsonp',
		        success:function(data) {
		        	if (data.error_code == 0) {
		        		alert(data.reason);
		        	} else {
		        		alert(data.reason);
		        	}
		        },
		        error:function(error,Msgerror){
		           
		        }
			});
		});
		
		$("#loginBtn").click(function () {
			var checkCode = $("#checkCode").val();
			if (!checkCode) {
				alert("请填写正确的验证码.");
				return ;
			}
			if (checkCode == numRandom) {
				var mobile = $("#mobile").val();
				if (!mobile) {
					alert("请填写正确的手机号码.");
					return ;
				}
				$.ajax({
			        url:'${ctx}/LoginServlet?action=login',
			        type:'POST',
			        data:{
			        	mobile: mobile
			        },
			        success:function(data) {
			           if ($.parseJSON(data).success) {
			        	   alert("登录成功");
			        	   window.location.href = "${ctx}/jsp/success.jsp";
			           }
			        },
			        error:function(error,Msgerror){
			           
			        }
				});
			} else {
				alert("请填写正确的验证码.");
			}
		});
	});
	
	function numRandom(n) {
		var num = "";
		for (var i = 0; i < n; i++) {
			num += Math.floor(Math.random()*10);
		}
		return num;
	}
	
</script>

</head>
<body data-vide-bg="../static/video/ship">
<section class="login-maintop">
	<div class="login-main">
		<header><h1>taped login form</h1></header>
		<div class="login-form">
			<h2>login now</h2>
			<form action="${ctx}/jsp/success.jsp" method="post">
				<span><i class="fa fa-user-o" aria-hidden="true"></i></span>
				 <input type="text" placeholder="手机号" id="mobile" name="mobile"  />
				<span><i class="fa fa-unlock-alt" aria-hidden="true"></i></span>
				  <input type="text" placeholder="6位数字验证码" id="checkCode" name="checkCode" required=""/> 
				  <input type="button"  id="btn" value="获取验证码"  />
				  <input type="button" id="loginBtn" value="登陆"/>
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