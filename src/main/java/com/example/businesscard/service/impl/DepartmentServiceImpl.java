package com.example.businesscard.service.impl;

import com.example.businesscard.entity.Department;
import com.example.businesscard.mapper.DepartmentMapper;
import com.example.businesscard.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<Department> ListDepartment() {
        return departmentMapper.getDepartment();
    }

    @Override
    public Department findByDepartment(String pname) {
       Department department = departmentMapper.findByDepartment(pname);
       return department;
    }

    @Override
    public void addDepartment(String pname, String premark) {

        departmentMapper.add(pname,premark);
        /*departmentMapper.resetDepartmentIds();
        departmentMapper.updateDepartmentIds();*/
    }

    @Override
    public void deleteDepartment(int pid) {

        departmentMapper.deleteById(pid);
        departmentMapper.resetDepartmentIds();
        departmentMapper.updateDepartmentIds();
    }


}
