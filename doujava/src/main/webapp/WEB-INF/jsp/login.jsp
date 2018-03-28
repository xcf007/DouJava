<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type=text/javascript>
	if ('${errorMsg}' != '') {
		alert('${errorMsg}');
	}
</script>
</head>
<body>
	<form method=post action="${pageContext.request.contextPath}/login">
		<div>
			<label>用户名：</label> <input type="text" value="${user.userName}"
				name="userName" />
		</div>
		<div>
			<label>密 码：</label> <input type="password" name="password" />
		</div>
		<div>
			<input type="submit" value="提交" />
		</div>
	</form>
</body>
</html>