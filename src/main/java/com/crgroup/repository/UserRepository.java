package com.crgroup.repository;

import com.crgroup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
   User findOneByUsername(String username);
}