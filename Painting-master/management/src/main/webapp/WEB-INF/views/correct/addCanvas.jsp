<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/24/024
  Time: 10:47
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
    <title>添加油画</title>
    <style type="text/css">
        label{
            font-size: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1 class="text-center">开始作品的旅程</h1>
    </div>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/addCanvas" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="firstname" class="col-sm-2 control-label">名称</label>
            <div class="col-sm-12">
                <input type="text" name="name" class="form-control" id="firstname"
                       placeholder="请输入要添加的油画名称">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">创作人</label>
            <div class="col-sm-12">
                <input type="text" name="creator" class="form-control" id="lastname"
                       placeholder="请输入油画创作人">
            </div>
        </div>
        <div class="form-group col-12">
            <label for="category">分类</label>
            <select class="form-control" name="categoryId" id="category">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">价格</label>
            <div class="col-sm-12">
                <input type="number" name="price" class="form-control"
                       placeholder="请输入油画价格">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">描述</label>
            <div class="col-sm-12">
                <input type="text" name="description" class="form-control"
                       placeholder="为你的油画添加点描述吧">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">细节</label>
            <div class="col-sm-12">
                <textarea class="form-control" name="detail" rows="3" placeholder="说说油画的创作背景或者油画的表示含义更容易让别人了解你的画哦"></textarea>
            </div>
        </div>

        <div class="form-group">
            <label for="inputfile" class="col-sm-10 control-label">选择你的油画图片</label>
            <div class="col-12">
                <input type="file" id="inputfile" name="smallImg" multiple accept=".jpg,.jpeg,.png" data-min-file-count="1"
                       data-show-preview="true">
            </div>
        </div>
        <div class="form-group text-center">
            <div class="col-12 text-center">
                <button type="submit" class="btn btn-primary btn-lg">提交作品</button>
            </div>
        </div>
    </form>
    <div style="height: 50px">
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(":input").attr("required","required");
    })
</script>
</body>
</html>
