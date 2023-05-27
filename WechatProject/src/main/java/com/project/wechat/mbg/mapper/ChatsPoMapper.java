package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.ChatsPo;
import com.project.wechat.mbg.pojo.ChatsPoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ChatsPoMapper {
    long countByExample(ChatsPoExample example);

    int deleteByExample(ChatsPoExample example);

    int deleteByPrimaryKey(Integer chatId);

    int insert(ChatsPo record);

    int insertSelective(ChatsPo record);

    List<ChatsPo> selectByExample(ChatsPoExample example);

    ChatsPo selectByPrimaryKey(Integer chatId);

    int updateByExampleSelective(@Param("record") ChatsPo record, @Param("example") ChatsPoExample example);

    int updateByExample(@Param("record") ChatsPo record, @Param("example") ChatsPoExample example);

    int updateByPrimaryKeySelective(ChatsPo record);

    int updateByPrimaryKey(ChatsPo record);
}