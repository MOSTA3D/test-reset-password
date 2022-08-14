package com.testSecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class UserEntity {
	@Id
	@SequenceGenerator(
		name = "user_sequence",
		sequenceName = "user_sequence",
		allocationSize = 1
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "user_sequence"
	)
	private Long id;
	
	@Column
	private String name;
	@Column(unique=true)
	private String email;
	@Column
	private String password;
	
	
}
