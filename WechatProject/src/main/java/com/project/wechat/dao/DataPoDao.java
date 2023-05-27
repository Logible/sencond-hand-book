package com.project.wechat.dao;

import com.project.wechat.mbg.pojo.DataPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DataPoDao {
    /*
    * 查找自己isbn库中是否有该书
    * */
    DataPo checkIsbnIsExist(@Param("isbnNum") String isbnNum);
    /*
    * 将数据插入自己的isbn库
    * */
    Integer insertIntoData(DataPo dataPo);
}
