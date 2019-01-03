<%--
  Date: 2018/12/28
  Time: 17:00
  desc:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<a href="params/pass?name=xxxxx&password=123456">请求传参数</a><br>

<form action="params/object" method="post">
    姓名：<input type="text" name="name"></br>
    密码：<input type="text" name="password"></br>
    钱数：<input type="text" name="money"></br>
    <input type="submit" value="提交"></br>
</form>
</br>

<a href="params/testParams?username=hftang">参数params</a><br>

<form action="params/testRequestBody" method="post">
    姓名：<input type="text" name="name"></br>
    密码：<input type="text" name="password"></br>
    钱数：<input type="text" name="money"></br>
    <input type="submit" value="提交测试requestBody"></br>
</form>
</br>

<a href="params/testPathVariable/100"> 测试pathVariable</a>

<%--测试传 list map 类型--%>
<form action="params/saveAccount" method="post">
    姓名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>

    用户姓名：<input type="text" name="list[0].uname"/><br/>
    用户年龄：<input type="text" name="list[0].age"/><br/>

    用户姓名：<input type="text" name="map['one'].uname"/><br/>
    用户年龄：<input type="text" name="map['one'].age"/><br/>
    <input type="submit" value="提交"/>
</form>

<%--测试日期 自定义日期转换类型--%>
<form action="params/saveUser" method="post">
    姓名：<input type="text" name="uname"/><br/>
    年龄：<input type="text" name="age"/><br/>
    日期：<input type="text" name="date"/><br/>
    <input type="submit" value="提交"/>
</form>

<%--测试获取原始的api--%>

<a href="params/getApi">获取原生api</a>

<%--获取 requestheader--%>

<a href="params/getHeader">getHeader</a>

<%--获取cookievalue--%>

<a href="params/getCookieValue">getCookieValue</a>

<%--测试 modelattribute--%>

<form action="params/testModelAttribute" method="post">
    姓名：<input type="text" name="uname"/><br/>
    <input type="submit" value="提交"/>
</form>



<a href="params/getSessionAttribute">getSessionAttribute</a><br>
<a href="params/obtainAttributes">getObtainAttributes</a><br>
<a href="params/delAttribute">delAttribute</a><br>


</body>
</html>
