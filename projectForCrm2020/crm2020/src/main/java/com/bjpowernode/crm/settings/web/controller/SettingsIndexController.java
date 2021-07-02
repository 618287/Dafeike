package com.bjpowernode.crm.settings.web.controller;

import com.bjpowernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SettingsIndexController {
    @Autowired
    private UserService userService;
    @RequestMapping("/settings/index.do")
    public String index(){
        return "settings/index";
    }
}
