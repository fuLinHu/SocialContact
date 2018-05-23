package com.imooc.shior.repository;

import com.imooc.shior.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
}
