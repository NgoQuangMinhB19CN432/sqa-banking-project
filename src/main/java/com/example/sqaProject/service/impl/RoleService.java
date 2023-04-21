package com.example.sqaProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sqaProject.entity.Role;
import com.example.sqaProject.repository.RoleRepository;
import com.example.sqaProject.service.IRoleService;

@Service
public class RoleService implements IRoleService{
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}
	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}
	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		roleRepository.delete(role);
	}
	@Override
	public Role findByCode(int code) {
		// TODO Auto-generated method stub
		return roleRepository.findByCode(code);
	}
}
