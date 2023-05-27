package com.project.wechat.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.project.wechat.dao.ChatsPoDao;
import com.project.wechat.dao.UtilsDao;
import com.project.wechat.dto.ChatInfo;
import com.project.wechat.mbg.pojo.ChatWindowPo;
import com.project.wechat.mbg.pojo.ChatsPo;
import com.project.wechat.mbg.pojo.GoodsPo;
import com.project.wechat.mbg.pojo.UserPo;
import com.project.wechat.service.ChatService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {
    @Resource
    private ChatsPoDao chatsPoDao;
    @Autowired
    private UtilsDao utilsDao;

    private final String BUYER = "0";
    private final String SELLER = "1";
    //得到未读消息
    @Override
    public Integer getUnreadMessages(Integer user_id) {
        Integer sum = 0;
        List<Integer> ChatWidList = chatsPoDao.getAllChatWid(user_id);
        for (Integer chatId : ChatWidList) {
            sum += chatsPoDao.getUnreadMessages(user_id,chatId);
        }
        return sum;
    }

    //插入一条消息到聊天数据库
    @Override
    public boolean insertNewMessage(ChatsPo chatsPo) {
        return chatsPoDao.insertNewMessage(chatsPo) > 0;
    }

//    得到聊天信息包括对方信息，商品信息和聊天记录
    @Override
    public ChatInfo getChatInfo(Integer chat_id, Integer user_id) {
        return setChatInfoMess(chat_id,user_id);
    }

//    删除某一个订单的所有聊天记录
    @Override
    public boolean deleteChats(Integer chatWid) {
        return chatsPoDao.deleteChats(chatWid) > 0;
    }

    //聊天页表
    @Override
    public List<ChatInfo> getChatList(Integer user_id) {
        List<Integer> ChatWidList = chatsPoDao.getAllChatWid(user_id);
        List<ChatInfo> chatInfoList = new ArrayList<>();
        for (Integer chatWId : ChatWidList) {
            chatInfoList.add(getChatInfo(chatWId,user_id));
        }
        return chatInfoList;
    }

    @Override
    public ChatsPo StringToChatPo(String chatPoStr) {
        return JSONObject.parseObject(chatPoStr,new TypeReference<ChatsPo>(){});
    }



    //将id为x的用户所有消息设置成已读

    @Override
    public Integer setAllHaveRead(Integer userId, Integer chatId) {
        return chatsPoDao.setAllHaveRead(userId,chatId);
    }

    //新建聊天窗口
    @Override
    public Integer createChatWin(ChatWindowPo chatWindowPo) {
        chatsPoDao.createChatWin(chatWindowPo);
        return chatWindowPo.getId();
    }

    @Override
    public ChatWindowPo StringToChatWinPo(String chatWinPoStr) {
        return JSONObject.parseObject(chatWinPoStr,new TypeReference<ChatWindowPo>(){});
    }

    //判断窗口是否存在
    @Override
    public Integer isChatWExist(ChatWindowPo chatWindowPo) {
        return chatsPoDao.isChatWExist(chatWindowPo);
    }

    //    根据chatwId查找userId
    private boolean getUserId(Integer chatWid,Integer userId){
        return chatsPoDao.getUserId(chatWid) == userId;
    }

    //设置chatInfo的信息
    private ChatInfo setChatInfoMess(Integer chat_id, Integer user_id){
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.setChat_id(chat_id);
        chatInfo.setMessages(chatsPoDao.getChatsBy(chat_id));
        chatInfo.setGoodsInfo(utilsDao.getGoodsByChatId(chat_id));
        chatInfo.getGoodsInfo().setPics(chatInfo.getGoodsInfo().getGoods_picture().split(","));
        chatInfo.getGoodsInfo().setUser(utilsDao.getUserById(chatInfo.getGoodsInfo().getSeller_id()));
        chatInfo.getGoodsInfo().getUser().setUser_school(utilsDao.getSchoolById(chatInfo.getGoodsInfo().getUser().getSchool_id()));
        chatInfo.setUnReadMessage(chatsPoDao.getUnreadMessages(user_id,chat_id));
        if(getUserId(chat_id,user_id) == true){
            chatInfo.setOppositeInfo(utilsDao.getUserByIdThroughChat(chat_id,SELLER));
        }else {
            chatInfo.setOppositeInfo(utilsDao.getUserByIdThroughChat(chat_id,BUYER));
        }

        chatInfo.getOppositeInfo().setUser_school(utilsDao.getSchoolById(chatInfo.getOppositeInfo().getSchool_id()));
        return chatInfo;
    }
}
