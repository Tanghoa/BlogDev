package com.lrm.service;


import com.lrm.entity.User;

public interface AdminService {


    User checkLogin(String username , String password );

    User getUserById(Long id);

}
