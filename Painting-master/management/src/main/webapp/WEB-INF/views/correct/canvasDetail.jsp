<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/25/025
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>油画详情</title>
    <link rel="stylesheet" type="text/css" href="/css/detail.css"/>
    <link rel="stylesheet" type="text/css" href="/css/common.css"/>
</head>
<c:set var="canvas" scope="request" value="${canvas}"/>
<body class="bgf8" style="background: #CCCCCC">
<div class="header">
    <ul class="breadcrumb" style="font-size:20px;padding-left: 100px">
        <li><a href="${pageContext.request.contextPath}/index" style="text-decoration: none;color:beige">回到主页 </a>/ 油画展示
        </li>
    </ul>
</div>
<div class="content">
    <div class="section" style="margin-top:20px;font-size: 30px;text-align: center">
        <div class="width1200">
            <div class="fl sec_intru_bg">
                <dl>
                    <dt>${canvas.name}</dt>
                    <dd>
                        <p>发布人：<span>${canvas.creator}</span></p>
                        <p>发布时间：<span><fmt:formatDate pattern="yyyy年MM月dd日" value="${canvas.createTime}"/></span></p>
                        <p>修改时间：<span><fmt:formatDate pattern="yyyy年MM月dd日" value="${canvas.updateTime}"/></span></p>
                    </dd>
                </dl>
                <ul>
                    <li>售价:<span class="price">${canvas.price}</span>元</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="secion_words" style="text-align: center;font-size: 30px;">
        <div class="width1200" style="text-align: center;font-size: 30px;">
            <div class="secion_wordsCon" style="text-align: center;font-size: 30px;">
                <p style="text-align: center;font-size: 30px;">${canvas.detail}</p>
            </div>
        </div>
    </div>
</div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</body>
</html>

