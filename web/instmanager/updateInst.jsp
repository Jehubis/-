<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/27
  Time: 15:15
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
        <li><a href="#">修改安装信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>安装信息</span></div>

    <form action="instManager.do" method="post">
        <input type="hidden" name="flag" value="modifyInst"/>
        <input type="hidden" name="instid" value="${installation1.instid}"/>
        <ul class="forminfo">
            <li><label>设备编号</label><input name="equ_num" type="text" class="dfinput" value="${installation1.equ_num}"/> </li>
            <li><label>设备名称</label><input name="equ_name" type="text" class="dfinput" value="${installation1.equ_name}"/> </li>
            <li><label>安装位置</label><input name="instposition" type="text" class="dfinput" value="${installation1.instposition}"/> </li>
            <li><label>安装日期</label><input name="instdate" type="text" class="dfinput" value="${installation1.instdate}"/> </li>
            <li><label>安装负责人</label><input name="instdirector" type="text" class="dfinput" value="${installation1.instdirector}"/></li>
            <li><label>安装单位</label><input name="instunit" type="text" class="dfinput" value="${installation1.instunit}"/></li>
            <li><label>检查负责人</label><input name="inspector" type="text" class="dfinput" value="${installation1.inspector}"/></li>
            <li><label>使用单位</label><input name="userunit" type="text" class="dfinput" value="${installation1.userunit}"/></li>
            <li><label>&nbsp;</label><input   type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>
</div>

</body>
</html>
