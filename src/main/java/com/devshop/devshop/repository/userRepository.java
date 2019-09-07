package com.devshop.devshop.repository;


import com.devshop.devshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, String> {
}
