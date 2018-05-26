package com.imooc.service;


import com.imooc.entity.User;

/**
 * Created by yangqj on 2017/4/21.
 */
public interface UserService extends IService<User>{
    void delUser(Integer userid);
    public User findByUsername(String username);
}
