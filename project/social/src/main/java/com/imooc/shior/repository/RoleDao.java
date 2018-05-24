package com.imooc.shior.repository;

import com.imooc.shior.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role,Long> {
    Iterable<Role> findAll(Sort sort);

    Page<Role> findAll(Pageable pageable);
}
