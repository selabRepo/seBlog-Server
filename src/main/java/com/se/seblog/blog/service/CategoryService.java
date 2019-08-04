package com.se.seblog.blog.service;

import java.util.List;

import com.se.seblog.DataCrudService;
import com.se.seblog.blog.model.entity.CategoryDto;

/**
 * 카테고리 서비스
 * 
 * @author youngjun.jin
 */
public interface CategoryService extends DataCrudService<CategoryDto, Long, CategoryDto> {

	/**
	 * 카테고리 전체 리스트를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return 카테고리 리스트
	 */
	public List<CategoryDto> getAll();

}
