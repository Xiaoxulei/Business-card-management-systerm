package com.example.businesscard;

import com.example.businesscard.entity.Department;
import com.example.businesscard.entity.User;
import com.example.businesscard.mapper.DepartmentMapper;
import com.example.businesscard.service.impl.DepartmentServiceImpl;
import com.example.businesscard.service.impl.UserServiceImpl;
import com.example.businesscard.utils.MD5Utils;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@MapperScan("com.example.businesscard.mapper")
@SpringBootTest
class BusinessCardApplicationTests {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    void contextLoads() {
        userService.register("111111","123456");
    }
    @Test
    void contextLoads1() {
        User existingUser = userService.findByUserName("123");
        if (existingUser != null) {
            // 如果用户名已存在，返回注册页面并提示错误
            userService.register("321","123456");
        }
    }
    @Test
    void contextLoads2(){
        User existingUser = userService.findByUserNameAndPassWord("111111","123456");
        if (existingUser != null)
            System.out.println(existingUser);
            else
            System.out.println("不存在");

    }
    @Autowired
    DepartmentServiceImpl departmentService;

    @Test
    void contextLoads3(){

            departmentService.deleteDepartment(28);

    }

}
