package com.zoie.example.service.impl;

import com.zoie.example.dao.UserDao;
import com.zoie.example.entity.User;
import com.zoie.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name="userDao")
    UserDao userDao;


    public  User getUserById(Long id){
        User user=(User)userDao.get(User.class,id);
        return user;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    public List<User> getUserList(){
        StringBuffer hql=new StringBuffer("select id,name,mobilePhone,sex from User");
        Object[] obj=new Object[]{};
       List<User> userList=userDao.find(hql.toString(),obj,1,20);
       return userList;
    }
}
