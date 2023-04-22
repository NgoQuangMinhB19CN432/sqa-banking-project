package com.example.sqaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sqaProject.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
		Role findByCode(int code);
}
