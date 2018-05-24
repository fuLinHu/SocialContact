package com.imooc.shior.service.impl;

import com.imooc.shior.MyShiroRealm;
import com.imooc.shior.model.UserRole;
import com.imooc.shior.repository.UserRoleDao;
import com.imooc.shior.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangqj on 2017/4/26.
 */
@Service("userRoleService")
public class UserRoleServiceImpl  implements UserRoleService {
    @Autowired
    private MyShiroRealm myShiroRealm;

    @Autowired
    private UserRoleDao mapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void addUserRole(UserRole userRole) {
        //删除
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userid",userRole.getUserid());
        mapper.deleteByExample(example);
        //添加
        String[] roleids = userRole.getRoleid().split(",");
        for (String roleId : roleids) {
            UserRole u = new UserRole();
            u.setUserid(userRole.getUserid());
            u.setRoleid(roleId);
            mapper.insert(u);
        }
        //更新当前登录的用户的权限缓存
        List<Integer> userid = new ArrayList<Integer>();
        userid.add(userRole.getUserid());
        myShiroRealm.clearUserAuthByUserId(userid);
    }

    @Override
    public Page<UserRole> findPage(Pageable pageable) {
        return mapper.findAll(pageable);
    }


    @Override
    public <S extends UserRole> S save(S var1) {
        return mapper.save(var1);
    }

    @Override
    public <S extends UserRole> Iterable<S> save(Iterable<S> var1) {
        return mapper.save(var1);
    }

    @Override
    public UserRole findOne(Long var1) {
        return mapper.findOne(var1);
    }

    @Override
    public boolean exists(Long var1) {
        return mapper.exists(var1);
    }

    @Override
    public Iterable<UserRole> findAll() {
        return mapper.findAll();
    }

    @Override
    public Iterable<UserRole> findAll(Iterable<Long> var1) {
        return mapper.findAll(var1);
    }

    @Override
    public long count() {
        return mapper.count();
    }

    @Override
    public void delete(Long var1) {
        mapper.delete(var1);
    }

    @Override
    public void delete(UserRole var1) {
        mapper.delete(var1);
    }

    @Override
    public void delete(Iterable<? extends UserRole> var1) {
        mapper.delete(var1);
    }

    @Override
    public void deleteAll() {
        mapper.deleteAll();
    }
}
