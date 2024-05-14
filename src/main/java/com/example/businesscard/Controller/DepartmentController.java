package com.example.businesscard.Controller;

import com.example.businesscard.entity.Department;
import com.example.businesscard.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.List;

@Controller
@RequestMapping("department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public String listDepartments(@RequestParam(name = "error", required = false) boolean error,Model model) {
        List<Department> departments = departmentService.ListDepartment();
        model.addAttribute("departments", departments);
       if(error){
            model.addAttribute("error", true);
        }
        return "department-list"; // 返回模板文件的名称
    }

    @GetMapping("addDepartment")
    public String addDepartment(String pname,String premark,Model model){
        /*try {
           departmentService.findByDepartment(pname);
        } catch (Exception e) {
            return "redirect:/department/departments?error=true";
        }*/
        if(departmentService.findByDepartment(pname)==null){
            departmentService.addDepartment(pname,premark);
            return "redirect:/department/departments";
        }
        else
            return "redirect:/department/departments?error=true";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 将字符串类型的参数转换为整数类型
        binder.registerCustomEditor(int.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                // 将字符串转换为整数
                int value = Integer.parseInt(text);
                // 设置转换后的整数值
                setValue(value);
            }
        });
    }

    @GetMapping("/deleteDepartment")
    public String deleteDepartment(@RequestParam("pid") String pidString) {
        int pid = Integer.parseInt(pidString);
        departmentService.deleteDepartment(pid);
        return "redirect:/department/departments"; // 删除成功后重定向到部门列表页面
    }



}

