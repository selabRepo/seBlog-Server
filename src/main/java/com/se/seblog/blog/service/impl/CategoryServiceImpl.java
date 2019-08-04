package com.se.seblog.blog.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.seblog.blog.model.entity.CategoryDto;
import com.se.seblog.blog.repository.CategoryRepository;
import com.se.seblog.blog.service.CategoryService;

/**
 * 카테고리 서비스 구현체
 * 
 * @author youngjun.jin
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	/** 카테고리 repository */
	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Optional<CategoryDto> get(Long id) {
		return this.categoryRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		this.categoryRepository.deleteById(id);
	}

	@Override
	public CategoryDto save(CategoryDto createModel) {
		return this.categoryRepository.save(createModel);
	}

	@Override
	public List<CategoryDto> getAll() {
		return this.categoryRepository.findAll();
	}

}
