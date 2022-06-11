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
        <li><a href="#">查询检修信息</a></li>
        <li><a href="#">查询结果</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="formtitle1"><span>检修信息列表</span></div>

    <table class="tablelist" >
        <thead>
        <tr>
            <th>检修单号</th>
            <th>设备编号</th>
            <th>设备名称</th>
            <th>设备类型</th>
            <th>检修员</th>
            <th>手机号码</th>
            <th>日期</th>
            <th>检修结果</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var="overhaul1" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${overhaul1.equ_num}</td>
                <td>${overhaul1.equ_name}</td>
                <td>${overhaul1.equ_type}</td>
                <td>${overhaul1.repairman}</td>
                <td>${overhaul1.phonenumber}</td>
                <td>${overhaul1.ovhdate}</td>
                <td>${overhaul1.ovhresult}</td>
                <td>${overhaul1.remarks}</td>
                <td><a href="ovhManager.do?flag=preUpdate&ovhid=${overhaul1.ovhid}" class="tablelink">修改</a> &nbsp;&nbsp;&nbsp;&nbsp;  <a href="ovhManager.do?flag=dropOvh&ovhid=${overhaul1.ovhid}" class="tablelink click"> 删除</a></td>
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
