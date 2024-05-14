package com.example.businesscard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToLoginPage() {
        // 重定向到登录页面
        return "redirect:/user/log";
    }
}
