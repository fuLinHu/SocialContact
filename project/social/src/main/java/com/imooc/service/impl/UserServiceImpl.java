package com.imooc.service.impl;


import com.imooc.entity.User;
import com.imooc.repository.UserRepository;
import com.imooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangqj on 2017/4/21.
 */
@Service("userService")
public class UserServiceImpl  implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public User findByUsername(String username) {
       return userRepository.findByUsername(username);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delUser(Integer userid) {
       /* //删除用户表
        userRepository.deleteByPrimaryKey(userid);
        //删除用户角色表
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userid",userid);
        userRoleMapper.deleteByExample(example);*/
    }

    @Override
    public Page<User> findPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


    @Override
    public <S extends User> S save(S var1) {
        return userRepository.save(var1);
    }

    @Override
    public <S extends User> Iterable<S> save(Iterable<S> var1) {
        return userRepository.save(var1);
    }

    @Override
    public User findOne(Long var1) {
        return userRepository.findOne(var1);
    }

    @Override
    public boolean exists(Long var1) {
        return userRepository.exists(var1);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<User> findAll(Iterable<Long> var1) {
        return userRepository.findAll(var1);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void delete(Long var1) {
        userRepository.delete(var1);
    }

    @Override
    public void delete(User var1) {
        userRepository.delete(var1);
    }

    @Override
    public void delete(Iterable<? extends User> var1) {
        userRepository.delete(var1);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
