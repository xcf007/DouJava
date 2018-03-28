<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DouJava管理后台</title>
<link href="${pageContext.request.contextPath}/resources/css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function refreshimage() {
		var cap = document.getElementById('vcode');
		cap.src = cap.src + '?';
	}
</script>
</head>
<body>
	<div id="login">
		<div class="dologo"></div>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<ul>
				<li class="inpLi"><b>用户名：</b><input type="text" name="user_name" class="inpLogin"></li>
				<li class="inpLi"><b>密码：</b><input type="password" name="password" class="inpLogin"></li>
				<li class="captchaPic">
					<div class="inpLi">
						<b>验证码：</b><input type="text" name="captcha" class="captcha">
					</div>
					<img id="vcode" src="../captcha.php" alt="启用验证码" border="1" onClick="refreshimage()" title="看不清？点击更换另一个验证码。">
				</li>
				<li class="sub">
					<input type="submit" name="submit" class="btn" value="登录">
				</li>
				<li class="action">
					<a href="login.php?rec=password_reset">忘记密码？</a> <em class="separator">|</em> <a href="http://localhost/douphp/">返回首页</a>
				</li>
			</ul>
		</form>
	</div>
</body>
</html>