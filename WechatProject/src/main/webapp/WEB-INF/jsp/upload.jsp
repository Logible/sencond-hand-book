<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2021/6/4
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UploadFile</title>
</head>
<body>
<form method="post" action="/COSOperate/uploadUserAvatar" enctype="multipart/form-data">
    <input type="file" name="file" value="choose Image">
    <input type="submit" value="upload">
</form>
</body>
</html>
