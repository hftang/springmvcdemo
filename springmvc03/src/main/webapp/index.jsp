<%--
  Created by IntelliJ IDEA.
  User: 61777
  Date: 2019/1/4
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="user/hello">test hello</a></br>

<button id="btn">发送ajax请求</button>
</br>

<%--上传文件--%>

<form action="user/fileupload1" method="post" enctype="multipart/form-data">
    <input type="file" name="upload">
    <input type="submit" value="上传文件">
</form>
</br>

<%--上传文件的02方式--%>

<form action="user/uploadFiles" method="post" enctype="multipart/form-data">
    <input type="file" name="upload">
    <input type="submit" value="上传文件02">
</form>

<%--上传文件方式03 跨域上传--%>
<form action="user/uploadfile03" method="post" enctype="multipart/form-data">
    <input type="file" name="upload">
    <input type="submit" value="上传文件03">
</form>



<script src="js/jquery.min.js"></script>
<script>
    $(function () {
        $("#btn").click(function () {

            $.ajax({
                url: "user/recejson",
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

        })
    })


</script>

</body>
</html>
