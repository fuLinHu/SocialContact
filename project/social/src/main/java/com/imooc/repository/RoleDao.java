package com.imooc.repository;

import com.imooc.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleDao extends CrudRepository<Role,Long> {
    Iterable<Role> findAll(Sort sort);

    Page<Role> findAll(Pageable pageable);

    @Query(value = "select r.id,r.roleDesc from role r \n" +
            "INNER JOIN user_role ur on r.id=ur.roleId\n" +
            "where ur.userId!=?1",nativeQuery = true)
    public List<Role> queryRoleListWithSelected(Integer uid);
}
