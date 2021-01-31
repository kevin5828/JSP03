<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/2
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试获取前端form表单数据</title>
</head>
<body>
<%
//请求对象
   String keyword= request.getParameter("keyword");
   out.print(keyword);
    out.print(keyword);
%>
</body>
</html>
