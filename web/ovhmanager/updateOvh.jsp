<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/23
  Time: 10:51
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
        <li><a href="#">检修信息管理</a></li>
        <li><a href="#">修改检修信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>检修信息</span></div>

    <form action="ovhManager.do" method="post">
        <input type="hidden" name="flag" value="modifyOvh"/>
        <input type="hidden" name="ovhid" value="${overhaul1.ovhid}"/>
        <ul class="forminfo">
            <li><label>设备编号</label><input name="equ_num" type="text" class="dfinput" value="${overhaul1.equ_num}"/> </li>
            <li><label>设备名称</label><input name="equ_name" type="text" class="dfinput" value="${overhaul1.equ_name}"/> </li>
            <li><label>设备类型</label><input name="equ_type" type="text" class="dfinput" value="${overhaul1.equ_type}"/> </li>
            <li><label>检修员</label><input name="repairman" type="text" class="dfinput" value="${overhaul1.repairman}"/> </li>
            <li><label>手机号码</label><input name="phonenumber" type="text" class="dfinput" value="${overhaul1.phonenumber}"/> </li>
            <li><label>日期</label><input name="ovhdate" type="text" class="dfinput" value="${overhaul1.ovhdate}"/> </li>
            <li><label>检修结果</label><input name="ovhresult" type="text" class="dfinput" value="${overhaul1.ovhresult}"/></li>
            <li><label>备注</label><input name="remarks" type="text" class="dfinput" value="${overhaul1.remarks}"/></li>
            <li><label>&nbsp;</label><input   type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>
</div>

</body>
</html>
