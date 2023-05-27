package com.project.wechat.dao;

import com.project.wechat.mbg.pojo.SchoolPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SchoolPoDao {
    /*
    * 根据学校名查找学校
    * */
    public List<SchoolPo> searchSchoolByName(@Param("schoolName")String schoolName);
}
