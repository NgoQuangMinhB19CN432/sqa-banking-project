package com.example.sqaProject.service;

import java.util.List;

import com.example.sqaProject.entity.Role;

public interface IRoleService {
	List<Role> findAll();
	void save(Role role);
	void delete(Role role);
	Role findByCode(int code);
	int update(int code,String name,String content,String status,String mBy,String mDate,int code2);
}
