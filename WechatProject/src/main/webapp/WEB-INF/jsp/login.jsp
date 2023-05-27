<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2021/5/17
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" deferredSyntaxAllowedAsLiteral="true"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <script
            src="/static/js/jquery-1.11.3.min.js"></script>
    <script>
        function check(){
            var usercode = $("#username").val();
            var password = $("#password").val();
            if(usercode=="" || password==""){
                $("#message").text("账号或密码不能为空！");
                return false;
            }
            return true;
        }
    </script>
    <style>
        h1{
            margin-left: 500px;
            margin-top: 130px;
        }
        #LoginWin{
            margin-left: 500px;
            border-style: solid;
            border-width: 5px;
            border-color: blueviolet;
            border-radius: 10px;
            width: 230px;
        }
        #submit{
            margin-left: 95px;
        }
    </style>
</head>

<body>
<form action="${pageContext.request.contextPath }/manage/Login" onsubmit="return check()">
    <h1>后台管理系统</h1>
    <div id = "LoginWin" style="margin-left:70px">
        <div style="margin-top: 20px">
            账号: <input type="text" name="username" id="username"> <br>
            密码: <input type="text" name="password" id="password"> <br>
            <input type="submit" value="login">
        </div>
    </div>
</form>
</body>
</html>
