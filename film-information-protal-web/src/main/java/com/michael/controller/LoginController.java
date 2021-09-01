package com.michael.controller;

import com.michael.pojo.User;
import com.michael.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/name")
    public Map name(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        if(name!=null){
            Map map = new HashMap();

            User user =userService.findOne(name);



            map.put("loginName",name);
            map.put("nickname",user.getNicknmae());
            map.put("userId",user.getUserId());
            return map;
        }
        return null;

    }
}
