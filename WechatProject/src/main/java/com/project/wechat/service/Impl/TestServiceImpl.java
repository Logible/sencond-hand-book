package com.project.wechat.service.Impl;

import com.project.wechat.dao.TestPoDao;
import com.project.wechat.mbg.mapper.TestPoMapper;
import com.project.wechat.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestPoDao testPoDao;


    @Override
    public boolean getValue() {
        return testPoDao.getValue() == 1;
    }
}
