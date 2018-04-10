<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="refresh" content="3; URL=${url}"/>
    <title>消息页面</title>
    <link href="${pageContext.request.contextPath}/resources/css/public.css" rel="stylesheet" type="text/css">
</head>
<body>
<c:choose>
    <c:when test="${out ne 'out'}">
    <div id="dcWrap">
        <%@ include file="header.jsp" %>
        <div id="dcLeft">
            <%@ include file="menu.jsp" %>
        </div>
        <div id="dcMain">
            <div id="urHere">DouJava 管理中心<b>&gt;</b><strong>网站管理员</strong></div>
            <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
                <h3>${urHere}</h3>
                <div id="douMsg">
                    <h2>${msgTitle}</h2>
                    <dl>
                        <dt>${skipText}</dt>
                        <dd><a href="<c:if test="${not empty url}">${url}</c:if><c:if test="${empty url}">javascript:history.go(-1);</c:if>">返回上一页</a></dd>
                    </dl>
                </div>
            </div>
        </div>
        <%@ include file="footer.jsp" %>
    </div>
    </c:when>
    <c:otherwise>
    <div id="outMsg">
        <h2>${msgTitle}</h2>
        <dl>
            <dt>${skipText}</dt>
            <dd><a href="${url}">返回上一页</a></dd>
        </dl>
    </div>
    </c:otherwise>
</c:choose>
</body>
</html>