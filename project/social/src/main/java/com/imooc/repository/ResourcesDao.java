package com.imooc.repository;

import com.imooc.entity.Resources;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;



public interface ResourcesDao extends CrudRepository<Resources,Long> {

    Iterable<Resources> findAll(Sort sort);

    Page<Resources> findAll(Pageable pageable);

}
