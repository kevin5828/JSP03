<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/2
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>根据关键字查询MySQL帮助主题</title>
</head>
<body>
<div>
    <h3>MySQL帮助主题查询</h3>
    <form action="help_topic_list.jsp"  method="post">
        <input type="text" name="keyword" style="width: 200px;height: 30px" placeholder="请输入关键字"/>
        <input type="submit" value="查询" style="height: 30px">
    </form>
</div>

</body>
</html>
