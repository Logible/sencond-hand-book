package com.project.wechat.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.project.wechat.mbg,com.project.wechat.dao")
public class MybatisConfig {

}
