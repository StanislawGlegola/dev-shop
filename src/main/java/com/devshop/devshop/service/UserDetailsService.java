package com.devshop.devshop.service;


import com.devshop.devshop.repository.ProductRepository1;
import com.devshop.devshop.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.devshop.devshop.model.User;


import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    private final ProductRepository1 productRepository1;

    public UserDetailsService(UserRepository userRepository, ProductRepository1 productRepository1) {
        this.userRepository = userRepository;
        this.productRepository1 = productRepository1;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findById(s).orElseThrow(() -> new UsernameNotFoundException("Could not find user with username: " + s));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}