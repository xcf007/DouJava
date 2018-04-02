<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="30; URL=${url}" />
<title>消息页面</title>
<link href="${pageContext.request.contextPath}/resources/css/public.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="outMsg">
 <h2>${msgTitle}</h2>
 <dl>
  <dt>${skipText}</dt>
  <dd><a href="${url}">返回上一页</a></dd>
 </dl>
</div>
</body>
</html>