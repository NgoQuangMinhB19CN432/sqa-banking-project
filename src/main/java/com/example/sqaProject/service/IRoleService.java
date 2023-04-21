package com.example.sqaProject.service;

import com.example.sqaProject.entity.Role;
import java.util.List;

public interface IRoleService {
	List<Role> findAll();
	void save(Role role);
	void delete(Role role);
	Role findByCode(int code);
}
