package com.imooc.service.impl;


import com.imooc.entity.RoleResources;
import com.imooc.repository.RoleResourcesDao;
import com.imooc.service.RoleResourcesService;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangqj on 2017/4/26.
 */
@Service("roleResourcesService")
public class RoleResourcesServiceImpl  implements RoleResourcesService {

    @Resource
    private RoleResourcesDao mapper;


    @Override
    public Page<RoleResources> findPage(Pageable pageable) {
        return mapper.findAll(pageable);
    }


    @Override
    public <S extends RoleResources> S save(S var1) {
        return mapper.save(var1);
    }

    @Override
    public <S extends RoleResources> Iterable<S> save(Iterable<S> var1) {
        return mapper.save(var1);
    }

    @Override
    public RoleResources findOne(Long var1) {
        return mapper.findOne(var1);
    }

    @Override
    public boolean exists(Long var1) {
        return mapper.exists(var1);
    }

    @Override
    public Iterable<RoleResources> findAll() {
        return mapper.findAll();
    }

    @Override
    public Iterable<RoleResources> findAll(Iterable<Long> var1) {
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
    public void delete(RoleResources var1) {
        mapper.delete(var1);
    }

    @Override
    public void delete(Iterable<? extends RoleResources> var1) {
        mapper.delete(var1);
    }

    @Override
    public void deleteAll() {
        mapper.deleteAll();
    }
}
