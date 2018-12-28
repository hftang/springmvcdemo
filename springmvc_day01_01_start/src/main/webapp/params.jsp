<%--
  Created by IntelliJ IDEA.
  User: 61777
  Date: 2018/12/28
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="params/pass?name=xxxxx&password=123456">请求传参数</a><br>

<form action="params/object" method="post">
    姓名：<input type="text" name="name"></br>
    密码：<input type="text" name="password"></br>
    钱数：<input type="text" name="money"></br>
    <input type="submit" value="提交"></br>
</form>
</body>
</html>
