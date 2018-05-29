package com.imooc.service.impl;

import com.imooc.entity.Role;
import com.imooc.repository.RoleDao;
import com.imooc.repository.RoleResourcesDao;
import com.imooc.service.RoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("roleService")
public class RoleServiceImpl  implements RoleService {

    @Resource
    private RoleDao mapper;
    @Resource
    private RoleResourcesDao roleResourcesMapper;


    @Override
    public List<Role> queryRoleListWithSelected(Integer uid) {
        return mapper.queryRoleListWithSelected(uid);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delRole(Long roleid) {
        //删除角色
        mapper.delete(roleid);
        //删除角色资源
        roleResourcesMapper.deleteByRoleid(roleid);

    }

    @Override
    public Page<Role> findPage(Pageable pageable) {
        return mapper.findAll(pageable);
    }


    @Override
    public <S extends Role> S save(S var1) {
        return mapper.save(var1);
    }

    @Override
    public <S extends Role> Iterable<S> save(Iterable<S> var1) {
        return mapper.save(var1);
    }

    @Override
    public Role findOne(Long var1) {
        return mapper.findOne(var1);
    }

    @Override
    public boolean exists(Long var1) {
        return mapper.exists(var1);
    }

    @Override
    public Iterable<Role> findAll() {
        return mapper.findAll();
    }

    @Override
    public Iterable<Role> findAll(Iterable<Long> var1) {
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
    public void delete(Role var1) {
        mapper.delete(var1);
    }

    @Override
    public void delete(Iterable<? extends Role> var1) {
        mapper.delete(var1);
    }

    @Override
    public void deleteAll() {
        mapper.deleteAll();
    }


}
