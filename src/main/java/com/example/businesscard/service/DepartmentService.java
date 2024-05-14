package com.example.businesscard.service;

import com.example.businesscard.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> ListDepartment();

    Department findByDepartment(String pname);

    void addDepartment(String pname,String premark);
    void deleteDepartment(int pid);
}
