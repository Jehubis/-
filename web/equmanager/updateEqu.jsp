<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/22
  Time: 0:38
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
        <li><a href="#">设备信息管理</a></li>
        <li><a href="#">修改设备信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>设备基本信息</span></div>

    <form action="equManager.do" method="post">
        <input type="hidden" name="flag" value="modifyEqu"/>
        <input type="hidden" name="equid" value="${equipment1.equid}"/>
        <ul class="forminfo">
            <li><label>设备名称</label><input name="equname" type="text" class="dfinput" value="${equipment1.equname}"/> </li>
            <li><label>设备编号</label><input name="equnum" type="text" class="dfinput" value="${equipment1.equnum}"/> </li>
            <li><label>设备类型</label><input name="equtype" type="text" class="dfinput" value="${equipment1.equtype}"/> </li>
            <li><label>设备供应商</label><input name="equsupplier" type="text" class="dfinput" value="${equipment1.equsupplier}"/> </li>
            <li><label>设备数量</label><input name="numofequ" type="text" class="dfinput" value="${equipment1.numofequ}"/></li>
            <li><label>设备价格</label><input name="price" type="text" class="dfinput" value="${equipment1.price}"/></li>
            <li><label>日期</label><input name="date" type="text" class="dfinput" value="${equipment1.date}"/></li>
            <li><label>&nbsp;</label><input   type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>

</div>
</body>
</html>
