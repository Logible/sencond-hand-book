package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.UserPo;
import com.project.wechat.mbg.pojo.UserPoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserPoMapper {
    long countByExample(UserPoExample example);

    int deleteByExample(UserPoExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    List<UserPo> selectByExample(UserPoExample example);

    UserPo selectByPrimaryKey(@Param("userId") Integer userId);

    int updateByExampleSelective(@Param("record") UserPo record, @Param("example") UserPoExample example);

    int updateByExample(@Param("record") UserPo record, @Param("example") UserPoExample example);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);
}