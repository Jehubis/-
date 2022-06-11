<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/23
  Time: 10:50
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
        <li><a href="#">检修信息管理</a></li>
        <li><a href="#">查询检修信息</a></li>
    </ul>
</div>

<div class="rightinfo" align="center">
    <form action="../ovhManager.do" method="post">
        <input type="hidden" name="flag" value="findOvh">
        <table class="prosearch" border="1px" align="center">
            <tr align="center" height="100px">
                <td ><label>检修单号:</label></td>
                <td ><input name="ovhid" type="text" class="dfinput" /></td>
            </tr>
            <tr align="center" height="100px">
                <td ><label>设备编号:</label></td>
                <td ><input name="equ_num" type="text" class="dfinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td ><label>设备名称:</label></td>
                <td ><input name="equ_name" type="text" class="dfinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td ><label>设备类型:</label></td>
                <td ><input name="equ_type" type="text" class="dfinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td ><label>检修员:</label></td>
                <td ><input name="repairman" type="text" class="dfinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td ><label>手机号码:</label></td>
                <td ><input name="phonenumber" type="text" class="dfinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td ><label>日期:</label></td>
                <td ><input name="ovhdate" type="text" class="dfinput" /></td>
            </tr>
            <tr  align="center" height="100px">
                <td><label>检修结果:</label></td>
                <td><textarea name="ovhresult" cols="42" rows="10" style="resize: none" ></textarea></td>
            </tr>
            <tr  align="center" height="100px">
                <td><label>备注:</label></td>
                <td><textarea name="remarks"  cols="42" rows="10" style="resize: none" ></textarea></td>
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
