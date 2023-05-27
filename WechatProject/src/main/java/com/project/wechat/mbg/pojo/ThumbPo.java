package com.project.wechat.mbg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThumbPo {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer goods_id;
    private Integer user_id;
}
