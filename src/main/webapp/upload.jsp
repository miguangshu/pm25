<%--
  Created by IntelliJ IDEA.
  User: katiemi
  Date: 2016/11/7
  Time: 下午8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传测试</title>
</head>
<body>

<form method="post" action="<%=request.getContextPath()%>/pm25/upload" enctype="multipart/form-data" >
    <p><input type="file" name="myfile1" value="浏览文件" /></p>
    <p><input type="submit" value="上传"/></p>
</form>
</body>
</html>
