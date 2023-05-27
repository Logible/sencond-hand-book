package com.project.wechat.dao;

import com.project.wechat.mbg.pojo.GoodTypePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsTypePoDao {
    //返回所有商品类型
    public List<GoodTypePo> getAllGoodsType();

    //根据typeId查询typeName
    public String selectTypeNameByTypeId(@Param("typeId") Integer typeId);
}
