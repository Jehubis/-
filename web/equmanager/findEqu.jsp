<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/21
  Time: 21:04
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
        <li><a href="#">设备信息管理</a></li>
        <li><a href="#">查询设备信息</a></li>
    </ul>
</div>

<div class="rightinfo" align="center">
    <form action="../equManager.do" method="post">
        <input type="hidden" name="flag" value="findEqu">
        <table class="prosearch" border="1px" align="center">
            <tr align="center" height="100px">
                <td ><label>设备名:</label></td>
                <td ><input name="equname" type="text" class="scinput" /></td>
            </tr>
            <tr align="center" height="100px">
                <td ><label>设备编号:</label></td>
                <td ><input name="equnum" type="text" class="scinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td ><label>设备类型:</label></td>
                <td ><input name="equtype" type="text" class="scinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td ><label>设备供应商：</label></td>
                <td ><input name="equsupplier" type="text" class="scinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td ><label>设备数量：</label></td>
                <td ><input name="numofequ" type="text" class="scinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td ><label>设备价格：</label></td>
                <td ><input name="price" type="text" class="scinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td><label>日期：</label></td>
                <td><input name="date" type="text" class="scinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td></td>
                <td><input type="submit" class="sure" value="查询" /></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
