package com.imooc.shior.repository;

import com.imooc.shior.model.RoleResources;
import com.imooc.shior.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
    Iterable<User> findAll(Sort sort);

    Page<User> findAll(Pageable pageable);
}
