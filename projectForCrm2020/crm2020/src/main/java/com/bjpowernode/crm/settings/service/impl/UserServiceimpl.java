package com.bjpowernode.crm.settings.service.impl;


import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.mapper.UserMapper;
import com.bjpowernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ************
 * 暗月     *********
 * **    *   *
 * **********
 * <p>
 * 2021/6/3
 */
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUS() {
       return userMapper.selectUS() ;
    }

    @Override
    public User selectVerify(Map<String, Object> map) {
        return userMapper.selectVerify(map);
    }
}
