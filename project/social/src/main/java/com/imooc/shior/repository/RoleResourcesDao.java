package com.imooc.shior.repository;

import com.imooc.shior.model.RoleResources;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface RoleResourcesDao extends CrudRepository<RoleResources,Long>{
    Iterable<RoleResources> findAll(Sort sort);

    Page<RoleResources> findAll(Pageable pageable);
}
