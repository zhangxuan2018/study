package com.zoie.example.dao.impl;

import com.zoie.example.common.dao.BaseDaoImpl;
import com.zoie.example.dao.UserDao;
import com.zoie.example.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {


}
