package com.example.businesscard.mapper;

import com.example.businesscard.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Select("SELECT pid, pname, premark FROM department")
    List<Department> getDepartment();

    @Select("select * FROM department  where pname = #{pname} ")
    Department findByDepartment(String pname);

    @Insert("insert into department(pname,premark)" +
            " values(#{pname},#{premark})")
    void add(String pname, String premark);


    @Delete("DELETE FROM department WHERE pid = #{pid}")
    void deleteById(int pid);

    // 定义更新部门编号的方法
    @Update("SET @count = 0;")
    void resetDepartmentIds();

    @Update("UPDATE department SET pid = @count:=@count+1;")
    void updateDepartmentIds();

}
