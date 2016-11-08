<%--
  Created by IntelliJ IDEA.
  User: hp123
  Date: 2016/11/4
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html ng-app="ionicApp">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width">
    <title>反馈</title>
    <link href="${pageContext.request.contextPath }/style/css/ionic.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/style/js/ionic.bundle.js"></script>
</head>
<body>

<!--头部-->
<h3>反馈</h3>
<div class="bar bar-header bar-positive">
    <a class="button button-icon icon ion-ios-arrow-back" href="#"><b>返回</b></a>
    <h1 class="h1 title"><b>反馈</b></h1>
</div>

<!--反馈内容表单-->
<form action="${pageContext.request.contextPath }/FeedBackServlet?method=Insert" method="post">
    <div class="list">
        <div class="item item-input item-select">
            <div class="input-label">
                反馈类型
            </div>
            <select>
                <option>软件BUG反馈</option>
                <option>产品建议</option>
            </select>
        </div>
    </div>

    <div class="content has-header">
        <div class="card">
            <div class="item item-divider">
                反馈内容
            </div>
            <div class="item item-text-wrap">
                <label class="item item-input">
                    <textarea name="message" ></textarea>
                </label>
            </div>
            <!--留下联系方式-->
            <div class="item item-divider">
                联系方式
            </div>
            <label class="item item-input">
                <i class="icon ion-person placeholder-icon"></i>
                <input type="text" placeholder="称呼">
            </label>
            <label class="item item-input">
                <i class="icon ion-android-mail placeholder-icon"></i>
                <input type="text" placeholder="邮箱">
            </label>

        </div>
    </div>
    <br>
    <div class="padding">
        <button class="button button-block button-positive">提交</button>
    </div>
</form>
</body>
</html>