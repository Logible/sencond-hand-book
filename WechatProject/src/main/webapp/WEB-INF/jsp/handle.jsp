<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2021/5/17
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserManageSystem</title>
    <style>
        .hide{
            display: none;
        }
        .modal{
            position:fixed;
            left:50%;
            top:50%;
            width:500px;
            height:400px;
            margin-left:-200px;
            margin-top:-250px;
            z-index:10;
            background-color:gray;
        }
    </style>
</head>
<h1>
    这是管理页面
</h1>
<script
        src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js">
</script>
<script src="${pageContext.request.contextPath}/static/js/jquery.json-2.4.js.ZIP.js">

</script>
<script>
    //删除用户
    function deleteUser(id) {
        $.post("${pageContext.request.contextPath}/manage/deleteUser",{userId:id},function (data) {
            alert(data == true?"删除成功":"删除失败");
            //确定后重新刷新数据
            selectAllUsers();
        })
    }
    //修改用户(把数据呈现在页面上)
    function updateUser(id) {
        var userPo = {};
        var userId = id.substr(1,id.length);
        $('#modifyWin').removeClass('hide');
        $.ajax({
            type:"post",
            dataType:"json",
            url:"${pageContext.request.contextPath}/manage/selectUserByPK",
            contentType:"application/json;charset=UTF-8",
            data:$.toJSON(userId),
            success:function (data) {
                userPo = JSON.parse(JSON.stringify(data));
                delete userPo.developer;
                delete userPo.avatar_url;

                var value = [];

                for (var x in userPo) {
                    value.push(userPo[x]);
                }

                var test = $('#modifyWin').find("input");

                $.each(test,function (index,item) {
                    if(index == 9){
                        return false;
                    }

                    item.value = value[index];
                });
            }
        });
        
    }
    //提交修改
    function submitModify() {
       var test = $('#modifyWin').find('input');
       var value = [];
       var usePo = {
           user_id:"",
           nick_name:"",
           user_status:"",
           user_campus_id:"",
           gender:"",
           language:"",
           city:"",
           province:"",
           country:"",
           user_openid:""
       };
       var i = 0;

       $.each(test,function (index,item) {
           value.push(item.value);
       })

        for (var x in usePo) {
            usePo[x] = value[i++];
        }

       $.ajax({
           type:"post",
           dataType:"json",
           url:"${pageContext.request.contextPath}/manage/updateUser",
           contentType:"application/json;charset=UTF-8",
           data:$.toJSON(usePo),
           success:function (data) {
               if(data == true){
                   alert("更新成功");
                   $('#modifyWin').addClass('hide');
                   selectAllUsers();
               }else {
                   alert("更新失败");
               }
           }
       });
    }
    //查询所有用户
    function selectAllUsers() {
        $.getJSON("${pageContext.request.contextPath}/manage/selectAllUser",function (data,status) {
            $("#dataSet").html(
                " <tr>"+
                "<th><input type='checkbox'></th>"+
                "<th>用户ID</th>"  +
                "<th>用户昵称</th>" +
                "<th>用户状态</th>" +
                "<th>用户校区ID</th>" +
                "<th>用户性别</th>" +
                "<th>用户语言</th>" +
                "<th>用户城市</th>" +
                "<th>用户省份</th>" +
                "<th>用户国家</th>" +
                "<th>用户的Open_Id</th>"+
                "<th>操作</th>"+
                "</tr>");
            $.each(data,function (index,item) {
                $("#dataSet").append(
                    "<tr>" +
                    "<td><input type='checkbox'></td>"+
                    "<td>"+item.user_id+"</td>" +
                    "<td>"+item.nick_name+"</td>" +
                    "<td>"+item.user_status +"</td>" +
                    "<td>"+item.user_campus_id+"</td>"+
                    "<td>"+ item.gender+"</td>"+
                    "<td>"+item.language +"</td>"+
                    "<td>"+ item.city+"</td>"+
                    "<td>"+item.province +"</td>"+
                    "<td>"+item.country +"</td>"+
                    "<td>"+ item.user_openid+"</td>"+
                    "<td>" +
                    "<button id=u"+item.user_id+" class='modify' onclick='updateUser(this.id)'>修改</button>" +
                    "<button id="+item.user_id+" onclick='deleteUser(this.id)'>删除</button>" +
                    "</td>" +
                    "</tr>"
                );
            })
        });
    }
    //获取新建用户的信息
    function getValueFromAddUser() {
        $("#addWin").removeClass('hide');
        var test = $('#addWin').find("input");
        var userPo = {
            nick_name:"",
            password:"",
            user_campus_id:"",
            gender:"",
            language:"",
            city:"",
            province:"",
            country:"",
            avatar_url:""
        };
        var value = [];
        var i = 0;
        $.each(test,function (index,item) {
            value.push(item.value);
            console.log(item.value);
        })

        for(var prop in userPo){
            userPo[prop] = value[i++];
        }

        console.log($.toJSON(userPo));

        $.ajax({
            type:"post",
            dataType:"json",
            url:"${pageContext.request.contextPath}/manage/addUser",
            contentType:"application/json;charset=UTF-8",
            data:$.toJSON(userPo),
            success:function (data) {
                if(data == true){
                    alert("成功");
                    //刷新表
                    selectAllUsers();
                }
            }
        });

        //将text里面的信息清空
        $('input[type="text"]').val('');
        $("#addWin").addClass('hide');
    }
$(document).ready(function () {
    //获得User管理的数据
    $("#toUserManage").click(function () {
        selectAllUsers();
    });
    //添加用户
    $('#add').click(function(){
        $('#addWin').removeClass('hide');
    });

    $('input[value="取消"]').click(function(){
        $('input[type="text"]').val('');
        $('.modal,.shade').addClass('hide');
    });

    //TODO 获得Goods管理的数据
});
</script>
<body>
当前用户:${USER_SESSION.nick_name} <a href="${pageContext.request.contextPath}/manage/logout">logout</a> <br>
<button id="toUserManage">User</button>
<button id="toGoodsManage">Goods</button>
    <div id="search">
        <input type="text">
        <input type="submit">
    </div>
    <button id="add">Add</button>
    <table id="dataSet" border="1">

    </table>

<%--添加用户页面--%>
    <div class="modal hide" id="addWin">
        <p>nick_name：<input type="text"></p>
        <p>password:<input type="text"> </p>
        <p>user_campus_id：<input type="text"></p>
        <p>gender: <input type="text"> </p>
        <p>language:<input type="text"> </p>
        <p>city:<input type="text"> </p>
        <p>province:<input type="text"> </p>
        <p>country:<input type="text"> </p>
        <p>avatar_url:<input type="text"> </p>
        <p><input id="addConfirm" type="button" onclick="getValueFromAddUser()" value="确定"><input type="button" value="取消"></p>
    </div>
<%--修改用户界面--%>
<div class="modal hide" id="modifyWin">
    <p>user_id: <input type="text"></p>
    <p>nick_name：<input type="text"></p>
    <p>password:<input type="text"> </p>
    <p>user_campus_id：<input type="text"></p>
    <p>gender: <input type="text"> </p>
    <p>language:<input type="text"> </p>
    <p>city:<input type="text"> </p>
    <p>province:<input type="text"> </p>
    <p>country:<input type="text"> </p>
    <p>avatar_url:<input type="text"> </p>
    <p><input id="modifyConfirm" type="button" onclick="submitModify()" value="确定"><input type="button" value="取消"></p>
</div>

</body>
</html>
