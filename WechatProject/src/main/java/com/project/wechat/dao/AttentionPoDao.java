package com.project.wechat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AttentionPoDao {
    public Integer countAttentions(Integer userId);
    Integer followUser(@Param("userId") Integer userId, @Param("followId") Integer followId);
    Integer unFollowUser(@Param("userId") Integer userId,@Param("followId") Integer followId);
}
