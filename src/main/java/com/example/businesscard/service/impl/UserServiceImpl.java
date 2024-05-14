package com.example.businesscard.service.impl;

import com.example.businesscard.entity.User;
import com.example.businesscard.mapper.DepartmentMapper;
import com.example.businesscard.mapper.UserMapper;
import com.example.businesscard.service.UserService;
import com.example.businesscard.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    @Override
    public User findByUserName(String username) {
        User user = userMapper.findByUserName(username);
        return user;
    }

    @Override
    public User findByUserNameAndPassWord(String username, String password) {
        User user = userMapper.findByUserNameAndPassWord(username,password);
        return user;
    }


    @Override
    public void register(String username, String password) {
        //密码加密
        /*String md5string = MD5Utils.string2MD5(password);*/
        //添加
        userMapper.add(username,password);
    }
}
