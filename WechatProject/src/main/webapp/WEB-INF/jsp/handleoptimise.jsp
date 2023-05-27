<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2021/5/22
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="referrer" content="no-referrer">
    <title>管理系统优化</title>
    <%--css文件引入--%>
    <link rel="stylesheet" href="/static/css/UserControl.css">
    <%--js文件引入--%>
    <script src="/static/js/jquery-1.11.3.min.js"></script>
    <script src="/static/js/jquery.json-2.4.js.ZIP.js"></script>
    <script src="/static/js/control/UserControl.js"></script>
</head>
<body>
    <%--整个控制面板--%>
    <div id="pad">
        <%--用户状态UI--%>
        <div id="user">
            <%--显示当前用户名和退出登录机制--%>
            当前用户:${USER_SESSION.su_id} <a href="${pageContext.request.contextPath}/manage/logout">logout</a><br>
        </div>
            <%--切换管理页面--%>
        <div id="SwitchControl">
            <button id="toUserManage">用户控制</button>
            <button id="toGoodsManage">商品控制</button>
            <button id="toReportManage">举报控制</button>
        </div>
            <%--搜索栏--%>
        <div id="SearchBar">
            <input id="search" type="text">
        </div>
            <%--添加用户按钮--%>
        <div id="addUser">
            <button id="add">添加用户</button>
        </div>
            <%--控制数据展示--%>
        <div id="dataDisplay">
            <%--数据展示的table--%>
            <table id="dataSet" border="1">
            </table>
        </div>
    </div>

    <%--用户控制页面(添加、删除、修改)--%>
    <div>
        <div id="UserPage" class="modal hide">
            <p>user_id:<input type="text"></p>
            <p>nick_name:<input type="text"></p>
            <p>user_status:<input type="text"></p>
            <p>user_campus_id：<input type="text"></p>
            <p>gender: <input type="text"> </p>
            <p>avatar_url:<input type="text"> </p>
            <p>user_openid<input type="text"></p>
            <p>user_campus<input type="text"></p>
            <p>
                <input id="addConfirm" type="button"  value="确定">
                <input type="button" value="取消">
            </p>
        </div>
    </div>

</body>
</html>
