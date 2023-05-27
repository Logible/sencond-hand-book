package com.project.wechat.dto;

import com.project.wechat.mbg.pojo.ChatsPo;
import com.project.wechat.mbg.pojo.GoodsPo;
import com.project.wechat.mbg.pojo.UserPo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatInfo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("聊天的id")
     private Integer chat_id;
    @ApiModelProperty("聊天消息的集合")
     private List<ChatsPo> messages;
    @ApiModelProperty("聊天对方用户的信息")
     private UserPo oppositeInfo;
    @ApiModelProperty("货物的信息")
     private GoodsPo goodsInfo;
    @ApiModelProperty("未读消息数")
    private Integer unReadMessage;

}
