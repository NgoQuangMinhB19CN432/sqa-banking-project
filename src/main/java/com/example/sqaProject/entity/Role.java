package com.example.sqaProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="code")
	private int code;
	
        @Column(name = "createdby")
	private String createdBy;
	@Column(name = "createddate")
	private String createdDate;
	@Column(name = "modifiedby")
	private String modifiedBy;
	@Column(name = "modifieddate")
	private String modifiedDate;
        
	@Column(name="title", nullable = false)
	private String name;
	
	@Column(name="content", nullable = false)
	private String content;
	
	@Column(name="role_status", nullable = false)
	private String status;
}
