package com.imooc.shior.service.impl;


import com.imooc.shior.MyShiroRealm;
import com.imooc.shior.model.RoleResources;
import com.imooc.shior.repository.RoleResourcesDao;
import com.imooc.shior.repository.UserRoleDao;
import com.imooc.shior.service.RoleResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangqj on 2017/4/26.
 */
@Service("roleResourcesService")
public class RoleResourcesServiceImpl  implements RoleResourcesService {
    @Resource
    private RoleResourcesDao mapper;
    @Autowired
    private MyShiroRealm myShiroRealm;

    @Override
    //更新权限
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    //@CacheEvict(cacheNames="resources", allEntries=true)
    public void addRoleResources(RoleResources roleResources) {
        /*//删除
        Example example = new Example(RoleResources.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleid",roleResources.getRoleid());
        mapper.deleteByExample(example);
        //添加
        if(!StringUtils.isEmpty(roleResources.getResourcesid())){
            String[] resourcesArr = roleResources.getResourcesid().split(",");
            for(String resourcesId:resourcesArr ){
                RoleResources r = new RoleResources();
                r.setRoleid(roleResources.getRoleid());
                r.setResourcesid(resourcesId);
                mapper.insert(r);
            }
        }

        List<Integer> userIds= userRoleMapper.findUserIdByRoleId(roleResources.getRoleid());
        //更新当前登录的用户的权限缓存
        myShiroRealm.clearUserAuthByUserId(userIds);*/
    }

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
