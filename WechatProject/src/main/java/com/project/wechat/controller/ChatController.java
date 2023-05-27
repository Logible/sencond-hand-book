package com.project.wechat.controller;

import com.project.wechat.dto.ChatInfo;
import com.project.wechat.mbg.pojo.ChatWindowPo;
import com.project.wechat.mbg.pojo.ChatsPo;
import com.project.wechat.service.ChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Api(tags = "ChatController")
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @ApiOperation("查询数据表中的未读消息")
    @RequestMapping("/getUnreadMessages")
    @ResponseBody
    public Integer getUnreadMessages(Integer userId){
        return chatService.getUnreadMessages(userId);
    }

    @ApiOperation("插入新消息")
    @RequestMapping("/insertNewMessage")
    @ResponseBody
    public boolean insertNewMessage(String chats){
        return chatService.insertNewMessage(chatService.StringToChatPo(chats));
    }

    @ApiOperation("得到聊天信息包括对方信息，商品信息和聊天记录")
    @RequestMapping("/getChatInfo")
    @ResponseBody
    public ChatInfo getChatInfo(Integer chatId, Integer userId){
        ChatInfo chatInfo = chatService.getChatInfo(chatId,userId);
        setChatInfo(chatInfo);
        return chatInfo;
    }

    @ApiOperation("删除某一个订单的所有聊天记录")
    @RequestMapping("/deleteChats")
    @ResponseBody
    public boolean deleteChats(Integer chatWid){
        return chatService.deleteChats(chatWid);
    }

    @ApiOperation("聊天页表")
    @RequestMapping("/getChatList")
    @ResponseBody
    public List<ChatInfo> getChatList(Integer userId){
        List<ChatInfo> chatInfoList = chatService.getChatList(userId);
        for (ChatInfo chatInfo : chatInfoList) {
          setChatInfo(chatInfo);
        }
        return chatInfoList;
    }

    @ApiOperation("设置指定窗口阿指定用户所有未读消息为已读")
    @RequestMapping("/setAllHaveRead")
    @ResponseBody
    Integer setAllHaveRead(Integer userId,Integer chatId){
        return chatService.setAllHaveRead(userId,chatId);
    }

    @ApiOperation("新建聊天窗口")
    @RequestMapping("/createChatWin")
    @ResponseBody
    Integer createChatWin(String chatWindowPo){
        ChatWindowPo chatWindowPo1 =  chatService.StringToChatWinPo(chatWindowPo);
        Integer id = chatService.isChatWExist(chatWindowPo1);
        if( id != null && id > 0){
            return id;
        }

        return chatService.createChatWin(chatWindowPo1);
    }

    //设置chatInfo的信息
    private void setChatInfo(ChatInfo chatInfo){
        for (ChatsPo message : chatInfo.getMessages()) {
            message.setSenderId(message.getSend_id());
        }
        chatInfo.getOppositeInfo().setUser_avatarUrl(chatInfo.getOppositeInfo().getAvatar_url());
        chatInfo.getOppositeInfo().setUser_gender(chatInfo.getOppositeInfo().getGender());
        chatInfo.getOppositeInfo().setUser_nickname(chatInfo.getOppositeInfo().getNick_name());
        chatInfo.getGoodsInfo().getUser().setUser_gender(chatInfo.getGoodsInfo().getUser().getGender());
        chatInfo.getGoodsInfo().getUser().setUser_avatarUrl(chatInfo.getGoodsInfo().getUser().getAvatar_url());
        chatInfo.getGoodsInfo().getUser().setUser_nickname(chatInfo.getGoodsInfo().getUser().getNick_name());
        chatInfo.getGoodsInfo().setGoods_upload_id(chatInfo.getGoodsInfo().getSeller_id());
    }
}
