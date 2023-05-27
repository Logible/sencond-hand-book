package com.project.wechat.mbg;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Generator {
   @Test
   public void generate() throws Exception{
      List<String> warnings = new ArrayList<String>();
      boolean overwrite = true;
      //直接填写配置文件的全路径
      File configFile = new File("D:\\Software\\Program\\ProgramCompilerWorkspace\\Java\\LocalProjectWorkspace\\IdeaWorkSpace\\MyProject\\WechatProject\\target\\classes\\generatorConfig.xml");
      ConfigurationParser cp = new ConfigurationParser(warnings);
      Configuration config = cp.parseConfiguration(configFile);
      DefaultShellCallback callback = new DefaultShellCallback(overwrite);
      MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
      myBatisGenerator.generate(null);
   }
}