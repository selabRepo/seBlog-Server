package com.se.seblog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.seblog.user.model.RoleDto;

public interface RoleRepository extends JpaRepository<RoleDto, Long>{

}
