package com.imooc.shior.repository;

import com.imooc.shior.model.Resources;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResourcesDao extends CrudRepository<Resources,Long> {

    Iterable<Resources> findAll(Sort sort);

    Page<Resources> findAll(Pageable pageable);

}
