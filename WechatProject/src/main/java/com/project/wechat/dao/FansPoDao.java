package com.project.wechat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FansPoDao {
    Integer countFans(Integer userId);
    Integer addFans(@Param("userId") Integer userId, @Param("fansId") Integer fansId);
    Integer unFansUser(@Param("userId") Integer userId,@Param("fansId") Integer fansId);
}
