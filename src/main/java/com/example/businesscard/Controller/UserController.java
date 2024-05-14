package com.example.businesscard.Controller;

import com.example.businesscard.entity.User;
import com.example.businesscard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.businesscard.entity.Result;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

   /* @PostMapping ("/register")
    public Result register(String username,String password){
        //查询用户
        User user =userService.findByUserName(username);
        //没有占用
        //注册
        if(user != null){
            userService.register(username,password);
            return Result.success();
        }
       else {
           //占用
           return Result.error("用户名已经被占用");
        }
    }*/

    @PostMapping("/register")
    public String register( String username,String password) {
        // 查询数据库，检查用户名是否已存在// 查询数据库，检查用户名是否已存在
        User existingUser = userService.findByUserName(username);
        if (existingUser != null) {
            // 如果用户名已存在，返回注册页面并提示错误
            return "redirect:/user/register";
        }

        // 如果用户名不存在，则注册新用户
        userService.register(username, password);

        // 注册成功后重定向到登录页面
        return "redirect:/user/log";
    }

    @GetMapping("/reg")
    public String reg() {
        return "register"; // 返回login.html
    }

    @GetMapping("/log")
    public String log() {
        return "login"; // 返回login.html
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu"; // 返回login.html
    }

    @PostMapping ("/login")
    public String login(String username, String password,Model model){
        // 查询数据库，检查用户名和密码是否存在
        User user =userService.findByUserNameAndPassWord(username,password);
        // 如果用户存在
        if(user != null){
            return "redirect:/user/menu";
        }
        else {
            model.addAttribute("error1", true);
        }
            return "login";
    }
}
