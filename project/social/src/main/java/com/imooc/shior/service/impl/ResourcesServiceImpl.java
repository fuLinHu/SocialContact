package com.imooc.shior.service.impl;


import com.imooc.shior.model.Resources;
import com.imooc.shior.repository.ResourcesDao;
;
import com.imooc.shior.service.ResourcesService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/25.
 */
@Service("resourcesService")
public class ResourcesServiceImpl implements ResourcesService {
    @Resource
    private ResourcesDao mapper;

    @Override
    public Page<Resources> findPage(Pageable pageable) {
        return mapper.findAll(pageable);
    }


    @Override
    public <S extends Resources> S save(S var1) {
        return mapper.save(var1);
    }

    @Override
    public <S extends Resources> Iterable<S> save(Iterable<S> var1) {
        return mapper.save(var1);
    }

    @Override
    public Resources findOne(Long var1) {
        return mapper.findOne(var1);
    }

    @Override
    public boolean exists(Long var1) {
        return mapper.exists(var1);
    }

    @Override
    public Iterable<Resources> findAll() {
        return mapper.findAll();
    }

    @Override
    public Iterable<Resources> findAll(Iterable<Long> var1) {
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
    public void delete(Resources var1) {
        mapper.delete(var1);
    }

    @Override
    public void delete(Iterable<? extends Resources> var1) {
        mapper.delete(var1);
    }

    @Override
    public void deleteAll() {
        mapper.deleteAll();
    }


    @Override
    public List<Resources> loadUserResources(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Resources> queryResourcesListWithSelected(Integer rid) {
        return null;
    }



   /* @Override
    public PageInfo<Resources> selectByPage(Resources resources, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Resources.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<Resources> userList = selectByExample(example);
        return new PageInfo<>(userList);
    }*//*

    @Override
    public List<Resources> queryAll(){
        Iterable<Resources> all = mapper.findAll();
        return null;
    }

    @Override
    //@Cacheable(cacheNames="resources",key="#map['userid'].toString()+#map['type']")
    public List<Resources> loadUserResources(Map<String, Object> map) {
        return mapper.loadUserResources(map);
    }

    @Override
    public List<Resources> queryResourcesListWithSelected(Integer rid) {
        return mapper.queryResourcesListWithSelected(rid);
    }*/
}
