package com.example.businesscard.mapper;


import com.example.businesscard.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper
{
    //根据用户名查询用户
    @Select("select * from user where username = #{username} ")
    User findByUserName(String username);

    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    User findByUserNameAndPassWord(String username,String password);

    //添加用户
    @Insert("insert into user(username,password)" +
            " values(#{username},#{password})")
    void add(String username, String password);

}
