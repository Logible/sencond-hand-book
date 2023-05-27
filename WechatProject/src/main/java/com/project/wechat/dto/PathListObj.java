package com.project.wechat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PathListObj {
    private static final long serialVersionUID = 1L;
    List<String> pathList;
}
