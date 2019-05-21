<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>主页</title>
</head>
<style>
    .breadcrumb{
        text-decoration: none;
        font-weight: lighter;
    }
</style>
<body>
<div class="container col-10">
    <div class="jumbotron">
        <h1 class="display-3 text-center">分类油画展示</h1>
    </div>
    <ul class="breadcrumb" style="font-size:20px">
        <li><a href="${pageContext.request.contextPath}/index">回到主页 </a></li>
        <li class="active">/分类油画展示</li>
    </ul>
    <h2>${categoryName}类</h2>
    <table class="table table-bordered col-10 text-center">
        <thead>
        <tr>
            <th>油画名称</th>
            <th>创作者</th>
            <th>价格</th>
            <th>描述</th>
            <th>创建时间</th>
            <th>最后更新时间</th>
            <th>删除</th>
            <th>查看详情</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${canvas}">
            <tr>
                <th>${item.name}</th>
                <th>${item.creator}</th>
                <th>${item.price}</th>
                <th>${item.description}</th>
                <th><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.createTime}"/></th>
                <th><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.updateTime}"/></th>
                <th><a href="${pageContext.request.contextPath}/deleteCanvas?id=${item.id}">删除</a></th>
                <th><a href="${pageContext.request.contextPath}/canvasDetail?id=${item.id}">查看</a></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <ul class="pagination pagination-lg offset-3">
        <li class="page-item"><a class="page-link" id="first" href="${pageContext.request.contextPath}/categoryList?get=first&page=${page}&categoryId=${categoryId}">首页</a></li>
        <li class="page-item" ><a class="page-link" id="prev" href="${pageContext.request.contextPath}/categoryList?get=prev&page=${page}&categoryId=${categoryId}">上一页</a></li>
        <li class="page-item"><a class="page-link" href="">当前页${page}</a></li>
        <li class="page-item" ><a class="page-link" id="next" href="${pageContext.request.contextPath}/categoryList?get=next&page=${page}&categoryId=${categoryId}">下一页</a></li>
        <li class="page-item" ><a class="page-link" id="last" href="${pageContext.request.contextPath}/categoryList?get=last&page=${page}&categoryId=${categoryId}">尾页</a></li>
    </ul>
</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
