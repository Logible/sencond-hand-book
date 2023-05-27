package com.project.wechat.dto;

import com.project.wechat.mbg.pojo.DataPo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 传递根据isbn查找到的书本信息数据
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ISBNPo {
    private static final long serialVersionUID = 1L;
    private DataPo data;
}
