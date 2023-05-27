package com.project.wechat.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    //将Druid的数据源添加到spring容器中
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }


    /*
    * 访问Druid 默认监控界面的配置
    * */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean =
                new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams = new HashMap<>();

        initParams.put("loginUsername","root");
        initParams.put("loginPassword","root");
        initParams.put("allow","");

        //ban掉某个ip
//        initParams.put("deny",)

        bean.setInitParameters(initParams);
        return bean;
    }


    /*
    * web监控的filter
    * */
    @Bean
    public FilterRegistrationBean webStatServlet(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String > initParams = new HashMap<>();

        initParams.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
