package com.testSecurity.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSecurity.demo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public Optional<UserEntity> findByEmail(String email);

}
