package com.project.wechat.dao;

import com.project.wechat.mbg.pojo.CategoryPo;
import com.project.wechat.mbg.pojo.GoodTypePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryPoDao {

    /*
    * 得到目录集合
    * */
    public List<CategoryPo> getCategory();

    /*
    * 得到某一目录的全部书籍分类
    * */
    public List<GoodTypePo> getGoodsTypeFrom(@Param("categoryId") Integer categoryId);
}
