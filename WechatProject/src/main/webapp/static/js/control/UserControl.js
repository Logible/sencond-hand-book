/*
* TODO user_id设置成只读
*  FIXME
*   bug：添加和删除用户页数不改变
*   优化:每次添加和删除如果要更新页码的话都要从数据库请求一次,(判断原数据+1后是否小于目前页数整数倍*3?小于则不查询，大于则查询)
* */

//控制管理页面页码的全局变量
var pageNum = 1;
var allPage = null;
//存储UserPage用户信息的全局变量
var toDisplayDataA;
function Userpo(user_id,nick_name,user_status,school_id,
                gender,avatar_url,user_openid,user_campus) {
    this.user_id = user_id;
    this.nick_name = nick_name;
    this.user_status = user_status;
    this.school_id = school_id;
    this.gender = gender;
    this.avatar_url = avatar_url;
    this.user_openid = user_openid;
    this.user_campus = user_campus;
}
function createUserPo() {
    let i = 0;
    var userPo = new Userpo();
    for (let index in userPo) {
        userPo[index] = toDisplayDataA[i++].value;
    }
    return userPo;
}
/*============用户显示部分============*/
//显示所有用户,TODO 导出为excel也许可以用
function displayAllUsers() {
    $.getJSON("/manage/selectAllUser",function (data,status) {
        $("#dataSet").html(
            " <tr>"+
            "<th><input type='checkbox'></th>"+
            "<th>用户ID</th>"  +
            "<th>用户昵称</th>" +
            "<th>用户状态</th>" +
            "<th>用户校区ID</th>" +
            "<th>用户性别</th>" +
            "<th>用户头像</th>"+
            "<th>用户的Open_Id</th>"+
            "<th>用户的校区</th>"+
            "<th>操作</th>"+
            "</tr>");
        $.each(data,function (index,item) {
            $("#dataSet").append(
                "<tr>" +
                "<td><input type='checkbox'></td>"+
                "<td>"+item.user_id+"</td>" +
                "<td>"+item.nick_name+"</td>" +
                "<td>"+item.user_status +"</td>" +
                "<td>"+item.school_id+"</td>"+
                "<td>"+ item.gender+"</td>"+
                "<td><img src={"+item.avatar_url+"}></td>" +
                "<td>"+ item.user_openid+"</td>"+
                "<td>"+ item.user_campus+"</td>"+
                "<td>" +
                "<button id=u"+item.user_id+" class='modify' onclick='updateUser(this.id)'>修改</button>" +
                "<button id=d"+item.user_id+" onclick='deleteUser(this.id)'>删除</button>" +
                "</td>" +
                "</tr>"
            );
        });
    });
}
//得到所有用户数
(function getAllPage() {
    $.ajax({
        type:"get",
        dataType: "json",
        url:"/manage/selectUserCounts",
        contentType: "application/json;charset=UTF-8",
        success:function (data) {
            allPage = Math.ceil(data / 10);
        }
    });
}());
function getAllPageOuter() {
    $.ajax({
        type:"get",
        dataType: "json",
        url:"/manage/selectUserCounts",
        contentType: "application/json;charset=UTF-8",
        success:function (data) {
            allPage = Math.ceil(data / 10);
        }
    });
}
//下一页
function nextPage(){
    if(pageNum + 1 > allPage){
        alert("没有下一页了");
        return ;
    }
    pageNum++;
    displayAllUsersP();
}
//上一页
function previousPage(){
    if(pageNum - 1 <= 0){
        alert("没有上一页了");
        return ;
    }
    pageNum--;
    displayAllUsersP();
}
//显示所有用户分页
function displayAllUsersP() {
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/manage/selectAllUserP",
        contentType:"application/json;charset=UTF-8",
        data:$.toJSON(pageNum),
        success:function (data) {
            $("#dataSet").html(
                "<tr>"+
                "<th><input type='checkbox'></th>"+
                "<th>用户ID</th>"  +
                "<th>用户昵称</th>" +
                "<th>用户状态</th>" +
                "<th>用户校区ID</th>" +
                "<th>用户性别</th>" +
                "<th>用户头像</th>"+
                "<th>用户的Open_Id</th>"+
                "<th>用户的校区</th>"+
                "<th>操作</th>"+
                "</tr>");

            $.each(data,function (index,item) {
                $("#dataSet").append(
                    "<tr id=t"+item.user_id+">" +
                    "<td><input type='checkbox'></td>"+
                    "<td>"+item.user_id+"</td>" +
                    "<td>"+item.nick_name+"</td>" +
                    "<td>"+item.user_status +"</td>" +
                    "<td>"+item.school_id+"</td>"+
                    "<td>"+ item.gender+"</td>"+
                    "<td><img src={"+item.avatar_url+"}></td>" +
                    "<td>"+ item.user_openid+"</td>"+
                    "<td>"+item.user_campus +"</td>"+
                    "<td>" +
                    "<button id=u"+item.user_id+" class='modify' onclick='displayToUserPage(this.id)'>修改</button>" +
                    "<button id=d"+item.user_id+" onclick='deleteUser(this.id)'>删除</button>" +
                    "</td>" +
                    "</tr>"
                );
            });

            $("#dataSet").append(
                "<tr>" +
                "<td>" +
                "<button id='previousPage' onclick='previousPage()'>上一页</button>"+
                "当前页:" + pageNum +
                "所有页:" + allPage +
                "<button id='nextPage' onclick='nextPage()'>下一页</button>"+
                "</td>"+
                "</tr>"
            );
        }
    });

}
/*============用户显示部分============*/
/*============用户删除部分============*/
function deleteUser(id){
    var userId = id.substr(1,id.length);
    $.ajax({
        type:"post",
        contentType:"application/json;charset=UTF-8",
        url:"/manage/deleteUser",
        dataType:"json",
        data:$.toJSON(userId),
        success:function (data) {
            if(data == true){
                alert("删除成功！");
            }else {
                alert("删除失败");
            }

            //刷新显示
            displayAllUsersP();
            //可能改变总页数
            getAllPageOuter();
        }
    });

    //更新页面显示
    displayAllUsersP();
}
/*============用户删除部分============*/
/*============用户更新部分============*/
//将默认信息显示在UserPage中
function displayToUserPage(id) {
    var userId = id.substr(1,id.length);
    var defaultData =  $('#t'+userId).find('td');
    var toDisplayData = $('#UserPage').find('input');
    var len = defaultData.length;

    for (let i = 1; i < len - 1; ++i) {
        if(defaultData[i].innerHTML.indexOf("img") == true){
            //去掉只留下<img src="">中src的内容
            toDisplayData[i-1].value =
                defaultData[i].innerHTML.substring(11,defaultData[i].innerHTML.length - 3);
            continue;
        }
        toDisplayData[i-1].value = defaultData[i].innerHTML;
    }

    $('#UserPage').removeClass('hide');
    toDisplayDataA = toDisplayData;
}
//将更新信息提交
function submitUpdate(userPo) {
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/manage/updateUser",
        contentType:"application/json;charset=UTF-8",
        data:$.toJSON(userPo),
        success:function (data) {
            if (data == true){
                alert("修改成功");
            }else {
                alert("修改失败");
            }
            displayAllUsersP();
        }
    });
}
/*============用户更新部分============*/
/*============用户添加部分============*/
function getNewUserData() {
    var PageObj = $('#UserPage').find('input');
    toDisplayDataA = PageObj;
    submitNewUser(createUserPo(toDisplayDataA));
}
function submitNewUser(userPo) {
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/manage//addUser",
        contentType:"application/json;charset=UTF-8",
        data:$.toJSON(userPo),
        success:function (data) {
            if(data == true){
                alert('添加成功');
            }else {
                alert('添加失败');
            }
            displayAllUsersP();
        }
    });
}
/*============用户添加部分============*/
//文档加载完成后的方法
$(document).ready(function () {
    //按取消清空page的内容并隐藏page
    $('input[value="取消"]').click(function(){
        $('input[type="text"]').val('');
        $('.modal,.shade').addClass('hide');
    });
    //按确定隐藏page
    $('input[value="确定"]').click(function(){
        $('.modal,.shade').addClass('hide');
    });
    //显示用户数据
    $('#toUserManage').click(function () {
        displayAllUsersP();
    });
    //按添加新用户按钮显示page进行提交
    $('#add').click(function () {
        $('#UserPage').removeClass('hide');
        $('#UserPage').addClass('ADD');

    });
    /*
    * 因为toDisplayDataA指向了DOM
    * 中的对象，所以对象的value改变了，
    * toDisplayDataA里的value也改变了，
    * 所以不需要重新写一个获得addConfirm的value
    * 的方法，只要改变addConfirm里面的value，
    * toDisplayDataA的value也会跟着改变
    * 所以直接传toDisplayDataA即可实现更新
    * 值
    * */
    $('#addConfirm').click(function () {
        //jquery无法读取ClassName.
        if(document.getElementById("UserPage").className.indexOf('ADD') > 0){
            getNewUserData();
            $('#UserPage').removeClass('ADD');
            getAllPageOuter();
        }else {
            submitUpdate(createUserPo(toDisplayDataA));
        }

        //清空userpage里的值
        $('input[type="text"]').val('');
    });
});