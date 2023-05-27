package com.project.wechat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 呈现给前端的地区
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    private static final long serialVersionUID = 1L;
    private String school;
    private String campus;
}
