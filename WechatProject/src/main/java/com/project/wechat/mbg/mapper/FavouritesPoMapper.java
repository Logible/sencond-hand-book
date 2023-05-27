package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.FavouritesPo;
import com.project.wechat.mbg.pojo.FavouritesPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FavouritesPoMapper {
    long countByExample(FavouritesPoExample example);

    int deleteByExample(FavouritesPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FavouritesPo record);

    int insertSelective(FavouritesPo record);

    List<FavouritesPo> selectByExample(FavouritesPoExample example);

    FavouritesPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FavouritesPo record, @Param("example") FavouritesPoExample example);

    int updateByExample(@Param("record") FavouritesPo record, @Param("example") FavouritesPoExample example);

    int updateByPrimaryKeySelective(FavouritesPo record);

    int updateByPrimaryKey(FavouritesPo record);
}