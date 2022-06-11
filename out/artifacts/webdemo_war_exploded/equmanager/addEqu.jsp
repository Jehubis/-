<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/21
  Time: 17:06
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
        <li><a href="#">设备信息管理</a></li>
        <li><a href="#">添加设备信息</a></li>
    </ul>
</div>

<div class="formbody" align="center">
    <div class="formtitle"><span>设备基本信息</span></div>
    <form action="../equManager.do" method="post">
        <input  type="hidden" name="flag" value="addEqu">
        <table class="forminfo" border="1px" align="center">
            <tr height="100px" align="center">
                <td width="100px"><label>设备名称:</label></td>
                <td width="100px"><input name="equname" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>设备编号:</label></td>
                <td width="100px"><input name="equnum" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>设备类型:</label></td>
                <td width="100px"><input name="equtype" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>设备供应商:</label></td>
                <td width="100px"><input name="equsupplier" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>设备数量:</label></td>
                <td width="100px"><input name="numofequ" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>设备价格:</label></td>
                <td width="100px"><input name="price" type="text" class="dfinput" /></td>
            </tr>
            <tr height="100px" align="center">
                <td width="100px"><label>日期:</label></td>
                <td width="100px"><input name="date" type="text" class="dfinput" /></td>
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
