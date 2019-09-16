package com.devshop.devshop.Repository;

import com.devshop.devshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
