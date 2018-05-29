package com.imooc.repository;

import com.imooc.entity.Resources;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ResourcesDao extends CrudRepository<Resources,Long> {

    Iterable<Resources> findAll(Sort sort);

    Page<Resources> findAll(Pageable pageable);

    @Query(value = "select r.id,r.name,r.resurl,r.type,r.parentid,r.sort from Resources r\n" +
            "INNER JOIN role_resources rr ON r.id=rr.resourcesId\n" +
            "INNER JOIN user_role ur ON rr.roleId=ur.roleId\n" +
            "INNER JOIN user u ON u.id=ur.userId\n" +
            "where u.id=?1",nativeQuery = true)
    List<Resources> loadUserResources(Integer userid);

    @Query(value = "select r.id,r.name,r.resurl,r.type,r.parentid,r.sort from Resources r\n" +
            "INNER JOIN role_resources rr ON r.id=rr.resourcesId\n" +
            "INNER JOIN user_role ur ON rr.roleId=ur.roleId\n" +
            "INNER JOIN user u ON u.id=ur.userId\n" +
            "where u.id=?1 AND r.type=?2",nativeQuery = true)
    List<Resources> loadUserResources(Integer userid, int type);
}
