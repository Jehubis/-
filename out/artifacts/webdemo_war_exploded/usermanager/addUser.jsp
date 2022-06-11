<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/21
  Time: 0:52
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
        <li><a href="#">用户信息管理</a></li>
        <li><a href="#">添加用户信息</a></li>
    </ul>
</div>

<div class="formbody" align="center">
    <div class="formtitle"><span>基本信息</span></div>
    <form action="../userManager.do" method="post">
        <input  type="hidden" name="flag" value="addUser">
        <table class="forminfo" border="1px" align="center">
            <tr height="100px" align="center">
                <td width="100px"><label>用户名:</label></td>
                <td width="100px"><input name="username" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>用户密码:</label></td>
                <td width="100px"><input name="userpwd" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>权限:</label></td>
                <td width="100px"><input name="userpower" type="radio" value="1" checked="checked" />用户&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="userpower" type="radio" value="0" />管理员</td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>性别:</label></td>
                <td width="100px"><input name="usersex" type="radio" value="1" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="usersex" type="radio" value="0" />女</td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>联系方式:</label></td>
                <td width="100px"><input name="phonenumber" type="text" class="dfinput" /></td>
            </tr>
            <tr height="50px" align="center">
                <td width="100px"><label>&nbsp;</label></td>
                <td width="50px"><input  type="submit"  class="btn" value="确认保存" />&nbsp;&nbsp;&nbsp;<input type="reset" class="loginbtn" value="重置" /></td>
            </tr>
        </table>
    </form>

</div>

</body>
</html>
