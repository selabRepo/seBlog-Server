package com.se.seblog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.seblog.user.model.entity.RoleDto;

public interface RoleRepository extends JpaRepository<RoleDto, Long>{

}
