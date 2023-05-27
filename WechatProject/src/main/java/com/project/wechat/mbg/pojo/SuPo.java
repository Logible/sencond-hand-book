package com.project.wechat.mbg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuPo {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String su_id;
    private String su_password;
}
