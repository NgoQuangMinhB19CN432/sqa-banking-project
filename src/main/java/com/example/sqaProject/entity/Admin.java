package com.example.sqaProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="admin")
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    	@Id
	@Column(name="id")
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name = "fullname")
	private String fullname;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	@Column(name = "address")
	private String address;
}
