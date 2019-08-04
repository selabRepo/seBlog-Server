package com.se.seblog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.seblog.blog.model.entity.CategoryDto;

/**
 * 카테고리 repository
 * 
 * @author youngjun.jin
 */
public interface CategoryRepository extends JpaRepository<CategoryDto, Long> {
	
}
