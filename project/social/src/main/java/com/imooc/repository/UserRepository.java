package com.imooc.repository;


import com.imooc.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.session.FindByIndexNameSessionRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    Iterable<User> findAll(Sort sort);
    Page<User> findAll(Pageable pageable);
    public User findByUsername(String username);
}
