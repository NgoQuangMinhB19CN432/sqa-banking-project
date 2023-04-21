package com.example.sqaProject.repository;

import com.example.sqaProject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>{
		Role findByCode(int code);
}
