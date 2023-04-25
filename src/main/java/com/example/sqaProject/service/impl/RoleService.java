package com.example.sqaProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.sqaProject.entity.Role;
import com.example.sqaProject.repository.RoleRepository;
import com.example.sqaProject.service.IRoleService;

@Service
public class RoleService implements IRoleService{
	private JdbcTemplate jdbc;
	@Autowired
	public RoleService(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
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
	@Override
	public int update(int code,String name,String content,String status,String mBy,String mDate,int code2) {
		return jdbc.update("update role set code=?, name=? , content=?, status=?, modifiedby=?,modifieddate=? where code=?", code,name,content,status,mBy,mDate,code2);
		
	}
//	private Role mapRowToProduct(ResultSet rs, int rowNum) throws SQLException {
//		Role role = new Role();
//		role.setCode(rs.getInt("code"));
//		role.setName(rs.getString("name"));
//		role.setContent(rs.getString("content"));
//		role.setStatus(rs.getString("status"));
//		return role;
//	}
}
