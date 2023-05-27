package com.project.wechat.service;

import com.project.wechat.dto.ChatInfo;
import com.project.wechat.mbg.pojo.ChatWindowPo;
import com.project.wechat.mbg.pojo.ChatsPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatService {
    //获取未读消息
    Integer getUnreadMessages(Integer user_id);
    //根据用户的id（role_id
    boolean insertNewMessage(ChatsPo chatsPo);

    //得到聊天信息包括对方信息，商品信息和聊天记录
    ChatInfo getChatInfo(Integer chat_id,Integer user_id);

    //删除某一个订单的所有聊天记录
    boolean deleteChats(Integer chatWid);

    //聊天页表
    public List<ChatInfo> getChatList(Integer user_id);

    //将String转换成ChatPo对象
    public ChatsPo StringToChatPo(String ChatPoStr);

    //将id为x的用户所有消息设置成已读
    Integer setAllHaveRead(Integer userId,Integer chatId);

    //新建聊天窗口
    Integer createChatWin(ChatWindowPo chatWindowPo);

    //String转化成ChatWinPo
    public ChatWindowPo StringToChatWinPo(String chatWinPoStr);

    //判断窗口是否存在
    public Integer isChatWExist(ChatWindowPo chatWindowPo);

}
