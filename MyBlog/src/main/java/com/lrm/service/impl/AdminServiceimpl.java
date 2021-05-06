package com.lrm.service.impl;

import com.lrm.entity.User;
import com.lrm.entity.UserExample;
import com.lrm.mapper.UserMapper;
import com.lrm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceimpl implements AdminService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User checkLogin(String username, String password) {

//        UserExample userExample = new UserExample();
////        UserExample.Criteria criteria = userExample.createCriteria();
////        criteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
////        List<User> users = userMapper.selectByExample(userExample);
////       if (users.get(0)!=null){
////           return users.get(0);
////       }

        User user = userMapper.queryByUsernameAndPassword(username, password);

        return user;
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
