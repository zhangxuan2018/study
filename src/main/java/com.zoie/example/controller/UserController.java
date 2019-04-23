package com.zoie.example.controller;

import com.zoie.example.entity.User;
import com.zoie.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name="userService")
    UserService userService;

    @RequestMapping(value="/getUserById")
    public String getUserById(Long id, HttpServletRequest request){

        if(id==null||id.longValue()<=0)return null;

        User user=userService.getUserById(id);
        request.setAttribute("user",user);

        return "user/my";
    }




    @RequestMapping(value="/saveUser")
    @ResponseBody
    public String save(User user){

        try {
           userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
        return "1";
    }
    @RequestMapping("/getUserList")
    @ResponseBody
    public List<User> getUserList(){
        List<User> userList=userService.getUserList();
        return userList;

    }

}
