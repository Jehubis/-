<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/27
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">安装信息管理</a></li>
        <li><a href="#">查询安装信息</a></li>
        <li><a href="#">查询结果</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="formtitle1"><span>安装信息列表</span></div>

    <table class="tablelist" >
        <thead>
        <tr>
            <th>安装单号</th>
            <th>设备名称</th>
            <th>设备编号</th>
            <th>安装位置</th>
            <th>安装日期</th>
            <th>安装负责人</th>
            <th>安装单位</th>
            <th>检查负责人</th>
            <th>使用单位</th>
            <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var="installation1" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${installation1.equ_num}</td>
                <td>${installation1.equ_name}</td>
                <td>${installation1.instposition}</td>
                <td>${installation1.instdate}</td>
                <td>${installation1.instdirector}</td>
                <td>${installation1.instunit}</td>
                <td>${installation1.inspector}</td>
                <td>${installation1.userunit}</td>
                <td><a href="instManager.do?flag=preUpdate&instid=${installation1.instid}" class="tablelink">修改</a> &nbsp;&nbsp;&nbsp;&nbsp;  <a href="instManager.do?flag=dropInst&instid=${installation1.instid}" class="tablelink click"> 删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>



    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="images/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>
</div>
</body>
</html>
