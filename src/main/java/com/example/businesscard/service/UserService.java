package com.example.businesscard.service;

import com.example.businesscard.entity.User;


public interface UserService {
    User findByUserName(String username);

    User findByUserNameAndPassWord(String username,String password);

    void register(String username, String password);

}
