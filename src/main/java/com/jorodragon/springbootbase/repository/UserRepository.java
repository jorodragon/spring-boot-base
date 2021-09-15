package com.jorodragon.springbootbase.repository;

import com.jorodragon.springbootbase.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepository extends SoftDeleteCrudRepository<User, Long> {
     User findByEmail(String email);
}
