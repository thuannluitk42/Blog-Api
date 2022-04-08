package com.thuannlu.springboot.blogrestapi.repository;

import com.thuannlu.springboot.blogrestapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
