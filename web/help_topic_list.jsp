<%@ page import="com.zh.jsp.dao.HelpTopicDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zh.jsp.entity.HelpTopic" %>
<%@ page import="com.zh.jsp.util.StringUtils" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/2
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MySQL帮助主题列表</title>
</head>
<body>
<%
    //通过请求对象获取前端页面填写的关键字
    String keyword = request.getParameter("keyword");
    HelpTopicDao helpTopicDao = new HelpTopicDao();
    List<HelpTopic> topicList = helpTopicDao.selectList(keyword);
%>
<table border="1" cellspacing="0" cellpadding="2" width="100%">
    <thead>
    <tr>
        <th>主题名称</th>
        <th>主题描述</th>
        <th>案例说明</th>
        <th>主题链接</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (topicList == null) {
            //查询发生异常
            out.print("<tr><td colspan='4' style='color:#FF0000'>查询发生异常!!!!</td></tr>");
        } else if (0 == topicList.size()) {
            //未查询到数据
            out.print("<tr><td colspan='4' style='color:#0000FF'>未查询到任何帮助主题!!!!</td></tr>");
        } else {
            String color = "#0000ff";//高亮背景颜色
            for (HelpTopic topic : topicList) {
                //将关键字高亮显示
                String name = topic.getName();
                name = StringUtils.isEmpty(keyword)?name:StringUtils.handleHighlightKeyword(name, keyword, color);
                String desc = topic.getDescription();
                desc = StringUtils.isEmpty(keyword)?desc:StringUtils.handleHighlightKeyword(desc, keyword, color);
                String example = topic.getDescription();
                example = StringUtils.isEmpty(keyword)?example:StringUtils.handleHighlightKeyword(example, keyword, color);
                out.print("<tr>");
                out.print("<td>" + name + "</td>");
                out.print("<td>" + desc + "</td>");
                out.print("<td>" + example + "</td>");
                out.print("<td><a href='" + topic.getUrl() + "'>查看</a></td>");
                out.print("</tr>");
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
