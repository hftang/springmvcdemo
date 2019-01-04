<%--
  Created by IntelliJ IDEA.
  User: 61777
  Date: 2019/1/3
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<a href="user/testString">testString</a>
<h3>重定向的页面</h3>

<button id="btn">点击ajax请求</button>


<script src="js/jquery.min.js"></script>
<script>
    $(function () {
        $("#btn").click(function () {
            $.ajax({
                url: "user/testAjax",
                contentType: "application/json;charset=UTF-8",
                data: '{"name":"hftang999","pwd":"334455","age":45}',
                dataType: "json",
                type: "post",
                success: function (data) {
                    console.log(data);
                    console.log(data.age);
                    console.log(data.pwd);
                    console.log(data.name);

                }
            })


        });
    })
</script>
</body>
</html>
