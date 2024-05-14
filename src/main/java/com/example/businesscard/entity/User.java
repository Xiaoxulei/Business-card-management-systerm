package com.example.businesscard.entity;

import lombok.Data;

import java.time.LocalDateTime;

//lombok 在编译阶段，为实体类自动生成setter、getter、toString
//pom文件引入依赖 在实体类上添加注解
@Data
public class User {
    private Integer id;//主键id

    private String username;//用户名

    private String password;//密码
}
