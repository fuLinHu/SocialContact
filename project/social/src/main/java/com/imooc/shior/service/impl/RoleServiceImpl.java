package com.imooc.shior.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.imooc.shior.model.Role;
import com.imooc.shior.model.RoleResources;
import com.imooc.shior.repository.RoleDao;
import com.imooc.shior.repository.RoleResourcesDao;

import com.imooc.shior.service.RoleService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


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
    public PageInfo<Role> selectByPage(Role role, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Role.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<Role> rolesList = selectByExample(example);
        return new PageInfo<>(rolesList);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delRole(Integer roleid) {
        //删除角色
        mapper.deleteByPrimaryKey(roleid);
        //删除角色资源
        Example example = new Example(RoleResources.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleid",roleid);
        roleResourcesMapper.deleteByExample(example);

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
