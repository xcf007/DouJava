<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DouJava 管理中心 - 网站管理员</title>
    <link href="${pageContext.request.contextPath}/resources/css/public.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/global.js"></script>
</head>
<body>
<div id="dcWrap">
    <%@ include file="header.jsp" %>
    <div id="dcLeft">
        <%@ include file="menu.jsp" %>
    </div>
    <div id="dcMain">
        <div id="urHere">DouJava 管理中心<b>&gt;</b><strong>网站管理员</strong></div>
        <div id="manager" class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
            <h3><a href="${actionLink.href}" class="actionBtn">${actionLink.text}</a>网站管理员</h3>
            <c:if test="${action eq 'default'}">
                <!-- 管理员添加 -->
                <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
                    <tr>
                        <th width="30" align="center">编号</th>
                        <th align="left">管理员名称</th>
                        <th align="center">E-mail地址</th>
                        <th align="center">添加时间</th>
                        <th align="center">最后登录时间</th>
                        <th align="center">操作</th>
                    </tr>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td align="center">${user.id}</td>
                            <td>${user.userName}</td>
                            <td align="center">${user.email}</td>
                            <td align="center"><fmt:formatDate value="${user.addTime}" pattern="yyyy-MM-dd"/></td>
                            <td align="center"><fmt:formatDate value="${user.lastLogin}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td align="center"><a href="#">编辑</a> | <a href="#">删除</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${action eq 'add'}">
                <!-- 管理员添加 -->
                <form action="${pageContext.request.contextPath}/manager/add" method="post">
                    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
                        <tr>
                            <td width="100" align="right">管理员名称</td>
                            <td>
                                <input type="text" name="userName" size="40" class="inpMain"/>
                            </td>
                        </tr>
                        <tr>
                            <td width="100" align="right">E-mail地址</td>
                            <td>
                                <input type="text" name="email" size="40" class="inpMain"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">密码</td>
                            <td>
                                <input type="password" name="password" size="40" class="inpMain"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">确认密码</td>
                            <td>
                                <input type="password" name="confirmPassword" size="40" class="inpMain"/>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" name="submit" class="btn" value="提交"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </c:if>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>