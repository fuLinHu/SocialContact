package com.imooc.repository;

import com.imooc.entity.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleDao extends CrudRepository<UserRole,Long> {
    Iterable<UserRole> findAll(Sort sort);

    Page<UserRole> findAll(Pageable pageable);
}
