package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.ChatWindowPo;
import com.project.wechat.mbg.pojo.ChatWindowPoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ChatWindowPoMapper {
    long countByExample(ChatWindowPoExample example);

    int deleteByExample(ChatWindowPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChatWindowPo record);

    int insertSelective(ChatWindowPo record);

    List<ChatWindowPo> selectByExample(ChatWindowPoExample example);

    ChatWindowPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChatWindowPo record, @Param("example") ChatWindowPoExample example);

    int updateByExample(@Param("record") ChatWindowPo record, @Param("example") ChatWindowPoExample example);

    int updateByPrimaryKeySelective(ChatWindowPo record);

    int updateByPrimaryKey(ChatWindowPo record);
}