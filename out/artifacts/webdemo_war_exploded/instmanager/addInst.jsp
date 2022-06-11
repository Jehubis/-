<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/27
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <link href="../css/select.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">安装信息管理</a></li>
        <li><a href="#">添加安装信息</a></li>
    </ul>
</div>

<div class="formbody" align="center">
    <div class="formtitle"><span>安装基本信息</span></div>
    <form action="../instManager.do" method="post">
        <input  type="hidden" name="flag" value="addInst">
        <table class="forminfo" border="1px" align="center">
            <tr height="100px" align="center">
                <td width="100px"><label>设备名称:</label></td>
                <td width="100px"><input name="equ_name" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>设备编号:</label></td>
                <td width="100px"><input name="equ_num" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>安装位置:</label></td>
                <td width="100px"><input name="instposition" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>安装日期:</label></td>
                <td width="100px"><input name="instdate" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>安装负责人:</label></td>
                <td width="100px"><input name="instdirector" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>安装单位:</label></td>
                <td width="100px"><input name="instunit" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>检查人:</label></td>
                <td width="100px"><input name="inspector" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>使用单位:</label></td>
                <td width="100px"><input name="userunit" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>&nbsp;</label></td>
                <td width="100px"><input  type="submit"  class="btn" value="确认保存" />&nbsp;&nbsp;&nbsp;<input type="reset" class="loginbtn" value="重置" /></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
