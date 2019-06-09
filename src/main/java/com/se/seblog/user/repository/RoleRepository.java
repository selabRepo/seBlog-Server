package com.se.seblog.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.seblog.user.entity.RoleVo;

public interface RoleRepository extends JpaRepository<RoleVo, Long>{

}
