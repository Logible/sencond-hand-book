package com.project.wechat.dao;

import com.project.wechat.mbg.pojo.ChatWindowPo;
import com.project.wechat.mbg.pojo.ChatsPo;
import com.project.wechat.mbg.pojo.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChatsPoDao {
    //查询数据库表中的未读消息
    /*
    * status 0表示未读
    * 1表示已读
    * */
    Integer getUnreadMessages(@Param("userId") Integer userId,@Param("chatId") Integer chatId);
    //根据用户的id（role_id）,chat_id,message插入一条消息到聊天数据库
    Integer insertNewMessage(ChatsPo chatsPo);
    //根据chatId查找聊天记录
    List<ChatsPo> getChatsBy(@Param("chatWid") Integer chatWid);
    //根据chatwId查找userId
    Integer getUserId(@Param("chatWid")Integer chatWid);
    //删除某一个订单的所有聊天记录
    Integer deleteChats(@Param("chatWid") Integer chatWid);
    //得到有关user_id的所有chat_wid
    List<Integer> getAllChatWid(@Param("userId") Integer userId);
    //将id为x的用户所有消息设置成已读
    Integer setAllHaveRead(@Param("userId") Integer userId,@Param("chatId") Integer chatId);
    //新建聊天窗口
    Integer createChatWin(ChatWindowPo chatWindowPo);
    //判断窗口是否存在
    Integer isChatWExist(ChatWindowPo chatWindowPo);

}
