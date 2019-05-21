<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/25/025
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>油画的分类</title>
    <style type="text/css">
        .jumbotron a{
            text-decoration: none;
            font-size: 23px;
        }
        .breadcrumb{
            text-decoration: none;
            font-weight: lighter;
            font-size: 23px;
        }
    </style>
</head>
<body>
<div class="container col-10">
    <div class="jumbotron">
        <h1 class="display-3 text-center">油画的分类</h1>
        <a href="${pageContext.request.contextPath}/addCategoryPage" class="offset-11">添加分类</a>
    </div>
    <ul class="breadcrumb" style="font-size:20px">
        <li><a href="${pageContext.request.contextPath}/index">回到主页 </a></li>
        <li class="active">/分类展示</li>
    </ul>
    <%
        String error= (String) request.getAttribute("addCategoryError");
        if(null!=error&&error.equals("1"))
        {
            %>
    <div class="alert alert-warning">
        <a href="#" class="close" data-dismiss="alert">
            &times;
        </a>
        <strong>该分类已经存在,换一个试试吧</strong>
    </div>
            <%
        }else if(null!=error&&error.equals("0"))
        {
            %>
    <div id="myAlert" class="alert alert-success">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <strong>分类添加成功!</strong>
    </div>
    <%
        }
    %>
    <table class="table table-bordered col-10 text-center">
        <thead>
        <tr>
            <th>分类名称</th>
            <th>分类描述</th>
            <th>创建时间</th>
            <th>最后更新时间</th>
            <th>删除</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categories}">
            <tr>
                <th>${category.name}</th>
                <th>${category.description}</th>
                <th><fmt:formatDate value="${category.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></th>
                <th><fmt:formatDate value="${category.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></th>
                <th><a href="${pageContext.request.contextPath}/deleteCategory?id=${category.id}">删除</a></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
