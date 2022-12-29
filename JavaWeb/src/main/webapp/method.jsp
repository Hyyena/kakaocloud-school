<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-29
  Time: PM 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="res.jsp?name=hyyen">GET 요청</a><br/>
<from method="post" action="res.jsp">
    Nickname: <input type="text" name="nicname"/>
    <input type="submit"/>Sumbit
</from>
</body>
</html>
