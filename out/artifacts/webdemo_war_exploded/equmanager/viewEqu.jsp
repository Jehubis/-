<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/21
  Time: 21:08
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
        <li><a href="#">查询设备信息</a></li>
        <li><a href="#">查询结果</a></li>
    </ul>
</div>

<div class="rightinfo">


    <div class="formtitle1"><span>设备信息列表</span></div>

    <table class="tablelist" >
        <thead>
        <tr>
            <th>序号</th>
            <th>设备名称</th>
            <th>设备编号</th>
            <th>设备类型</th>
            <th>设备供应商</th>
            <th>设备数量</th>
            <th>设备价格</th>
            <th>日期</th>
            <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var="equipment1" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${equipment1.equname}</td>
                <td>${equipment1.equnum}</td>
                <td>${equipment1.equtype}</td>
                <td>${equipment1.equsupplier}</td>
                <td>${equipment1.numofequ}</td>
                <td>${equipment1.price}</td>
                <td>${equipment1.date}</td>
                <td><a href="equManager.do?flag=preUpdate&equid=${equipment1.equid}" class="tablelink">修改</a> &nbsp;&nbsp;&nbsp;&nbsp;  <a href="equManager.do?flag=dropEqu&equid=${equipment1.equid}" class="tablelink click"> 删除</a></td>
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
