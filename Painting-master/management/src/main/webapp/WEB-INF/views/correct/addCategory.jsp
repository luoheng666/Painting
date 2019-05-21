<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/25/025
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>添加分类</title>
    <style type="text/css">
        label{
            font-size: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1 class="text-center">添加新的分类</h1>
    </div>
    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/addCategory">
        <div class="form-group">
            <label for="firstname" class="col-sm-2 control-label">名称</label>
            <div class="col-sm-12">
                <input type="text" name="name" class="form-control" id="firstname"
                       placeholder="请输入要添加的分类名称">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">描述</label>
            <div class="col-sm-12">
                <input type="text" name="description" class="form-control" id="lastname"
                       placeholder="为你的分类添加点描述吧">
            </div>
        </div>
        <div class="form-group text-center">
            <div class="col-12 text-center">
                <button type="submit" class="btn btn-primary btn-lg">提交分类</button>
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
