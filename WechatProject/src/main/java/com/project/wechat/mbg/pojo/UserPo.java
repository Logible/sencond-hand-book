package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Integer user_id;

    @ApiModelProperty(value = "用户的昵称")
    private String nick_name;

    @ApiModelProperty(value = "标记该用户的登录状态")
    private String user_status;

    @ApiModelProperty(value = "标记该用户的学校")
    private Integer school_id;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "用户的头像")
    private String avatar_url;

    @ApiModelProperty(value = "微信小程序的唯一Id")
    private String user_openid;

    @ApiModelProperty(value = "用户校区")
    private String user_campus;
    @ApiModelProperty(value = "用户注册到现在的时间")
    private Integer user_day;
    @ApiModelProperty(value = "用户个性签名")
    private String user_introduce;
    @ApiModelProperty(value = "用户获得赞赏数")
    private  Integer user_praise;

    //非数据库字段
    @ApiModelProperty("学校的名字")
    private String user_school;
    @ApiModelProperty("nick_name的映射")
    private String user_avatarUrl;
    @ApiModelProperty("gender的映射")
    private String user_gender;
    @ApiModelProperty("nick_name的映射")
    private String user_nickname;

}