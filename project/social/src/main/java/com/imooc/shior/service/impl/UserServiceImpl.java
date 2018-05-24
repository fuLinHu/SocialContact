package com.imooc.shior.service.impl;


import com.imooc.shior.model.User;
import com.imooc.shior.model.UserRole;
import com.imooc.shior.repository.UserDao;
import com.imooc.shior.repository.UserRoleDao;
import com.imooc.shior.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangqj on 2017/4/21.
 */
@Service("userService")
public class UserServiceImpl  implements UserService {
    @Resource
    private UserDao mapper;

    @Override
    public PageInfo<User> selectByPage(User user, int start, int length) {
        int page = start/length+1;
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(user.getUsername())) {
            criteria.andLike("username", "%" + user.getUsername() + "%");
        }
        if (user.getId() != null) {
            criteria.andEqualTo("id", user.getId());
        }
        if (user.getEnable() != null) {
            criteria.andEqualTo("enable", user.getEnable());
        }
        //分页查询
        PageHelper.startPage(page, length);
        List<User> userList = selectByExample(example);
        return new PageInfo<>(userList);
    }

    @Override
    public User selectByUsername(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<User> userList = selectByExample(example);
        if(userList.size()>0){
            return userList.get(0);
        }
            return null;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delUser(Integer userid) {
        //删除用户表
        mapper.deleteByPrimaryKey(userid);
        //删除用户角色表
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userid",userid);
        userRoleMapper.deleteByExample(example);
    }

    @Override
    public Page<User> findPage(Pageable pageable) {
        return mapper.findAll(pageable);
    }


    @Override
    public <S extends User> S save(S var1) {
        return mapper.save(var1);
    }

    @Override
    public <S extends User> Iterable<S> save(Iterable<S> var1) {
        return mapper.save(var1);
    }

    @Override
    public User findOne(Long var1) {
        return mapper.findOne(var1);
    }

    @Override
    public boolean exists(Long var1) {
        return mapper.exists(var1);
    }

    @Override
    public Iterable<User> findAll() {
        return mapper.findAll();
    }

    @Override
    public Iterable<User> findAll(Iterable<Long> var1) {
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
    public void delete(User var1) {
        mapper.delete(var1);
    }

    @Override
    public void delete(Iterable<? extends User> var1) {
        mapper.delete(var1);
    }

    @Override
    public void deleteAll() {
        mapper.deleteAll();
    }
}
