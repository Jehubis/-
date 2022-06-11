<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/27
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <link href="../css/select.css" rel="stylesheet" type="text/css" />



</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">安装信息管理</a></li>
        <li><a href="#">查询安装信息</a></li>
    </ul>
</div>

<div class="rightinfo" align="center">
    <form action="../instManager.do" method="post">
        <input type="hidden" name="flag" value="findInst">
        <table class="prosearch" border="1px" align="center">
            <tr align="center" height="100px">
                <td ><label>安装单号:</label></td>
                <td ><input name="instid" type="text" class="dfinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td ><label>设备名称:</label></td>
                <td ><input name="equ_name" type="text" class="dfinput" /></td>
            </tr>
            <tr align="center" height="100px">
                <td ><label>设备编号:</label></td>
                <td ><input name="equ_num" type="text" class="dfinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td ><label>安装位置:</label></td>
                <td ><input name="instposition" type="text" class="dfinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td ><label>安装日期:</label></td>
                <td ><input name="instdate" type="text" class="dfinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td><label>安装负责人:</label></td>
                <td><input name="instdirector" type="text" class="dfinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td><label>安装单位:</label></td>
                <td><input name="instunit" type="text" class="dfinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td><label>检查人:</label></td>
                <td><input name="inspector" type="text" class="dfinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td><label>使用单位:</label></td>
                <td><input name="userunit" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td></td>
                <td ><input type="submit" class="sure" value="查询" />&nbsp;&nbsp;&nbsp;<input type="reset" class="loginbtn" value="重置" /></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
