<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sponge.painting.utils.CookieUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>登录主页</title>
    <style type="text/css">
        .container{
            margin-top: 100px;
            border: 3px solid #ccc;
        }
    </style>
</head>
<body>
<div class="container col-4 jumbotron">
    <%
        //若记住密码,获取账号和密码
        String username=null;
        String password=null;
        Cookie[] cookies = request.getCookies();
        Cookie cookie1=CookieUtil.getCookie(cookies,"username");
        Cookie cookie2=CookieUtil.getCookie(cookies,"password");
        if(null!=cookie1&&null!=cookie2)
        {
            username=cookie1.getValue();
            password=cookie2.getValue();
        }
    %>
    <div class="text-center">
        <h2>用户登录界面</h2>
    </div>
    <%
        String noLogin= (String) request.getAttribute("noLogin");
        if(null!=noLogin&&noLogin.equals("1"))
        {
    %>
    <div class="alert alert-warning">
        <a href="#" class="close" data-dismiss="alert">
            &times;
        </a>
        <strong>请管理员登录后再进行此操作</strong>
    </div>
    <%
    }
    %>
    <%
        String loginError= (String) request.getAttribute("loginError");
        if(null!=loginError&&loginError.equals("1"))
        {
    %>
    <div class="alert alert-warning">
        <a href="#" class="close" data-dismiss="alert">
            &times;
        </a>
        <strong>账号或密码输入错误,请重新登录</strong>
    </div>
    <%
        }
    %>
    <c:set var="username" value="<%=username%>"/>
    <c:set var="password" value="<%=password%>"/>
    <form action="${pageContext.request.contextPath}/login">
        <div class="form-group">
            <label for="username">用户名:</label>
            <input type="text" required="required"class="form-control" value="${username}" name="username" id="username" placeholder="请输入用户名">
        </div>
        <div class="form-group">
            <label for="pwd">密码:</label>
            <input type="password" required="required"class="form-control" value="${password}" name="password" id="pwd" placeholder="请输入密码">
        </div>
        <div class="form-check">
            <input class="form-check-input" name="remember" checked="checked" type="checkbox">记住密码
            </label>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary btn-lg">登录</button>
        </div>
    </form>
</div>
</table>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>