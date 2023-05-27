package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.UploadPo;
import com.project.wechat.mbg.pojo.UploadPoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UploadPoMapper {
    long countByExample(UploadPoExample example);

    int deleteByExample(UploadPoExample example);

    int deleteByPrimaryKey(Integer uploadId);

    int insert(UploadPo record);

    int insertSelective(UploadPo record);

    List<UploadPo> selectByExample(UploadPoExample example);

    UploadPo selectByPrimaryKey(Integer uploadId);

    int updateByExampleSelective(@Param("record") UploadPo record, @Param("example") UploadPoExample example);

    int updateByExample(@Param("record") UploadPo record, @Param("example") UploadPoExample example);

    int updateByPrimaryKeySelective(UploadPo record);

    int updateByPrimaryKey(UploadPo record);
}