<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hp123
  Date: 2016/11/5
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html ng-app="ionicApp">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width">
    <title>反馈内容</title>
    <link href="style/css/ionic.css" rel="stylesheet">
    <script src="style/js/ionic.bundle.js"></script>
</head>

<body>
<!--头部-->
<table  align="center" border="1px" cellspacing="0px" cellpadding="0" style="border-collapse: collapse;">
    <!-- 表头-->

    <tr align="center" valign="middle" id="TableTitle">

        <td>建议条数</td>
        <td>建议内容</td>
        <td>建议时间</td>
    </tr>

    <!--显示数据列表 -->

    <c:forEach items="${requestScope.list}" var="User" varStatus="user">
        <tr class="TableDetail1">
            <td>${user.count }</td>
            <td>${User.message }</td>
            <td>${User.date }</td>
        </tr>
    </c:forEach>

</table>

<!-- 其他功能超链接 -->
<div id="TableTail" align="center">
    当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页     &nbsp;&nbsp;
    <a href="${pageContext.request.contextPath }/FeedBackServlet?method=list&currentPage=1">首页</a>
    <a href="${pageContext.request.contextPath }/FeedBackServlet?method=list&currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>
    <a href="${pageContext.request.contextPath }/FeedBackServlet?method=list&currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a>
    <a href="${pageContext.request.contextPath }/FeedBackServlet?method=list&currentPage=${requestScope.pageBean.totalPage}">末页</a>
</div>



</body>