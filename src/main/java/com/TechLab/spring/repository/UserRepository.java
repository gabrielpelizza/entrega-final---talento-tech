package com.TechLab.spring.repository;

import com.TechLab.spring.entity.Role;
import com.TechLab.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);
}