package com.se.seblog.blog.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.se.seblog.blog.model.dto.BlogPostDto;
import com.se.seblog.blog.repository.BlogPostRepository;
import com.se.seblog.blog.service.BlogPostService;

/**
 * 블로그 포스팅 서비스 구현
 * 
 * @author youngjun.jin
 */
@Service
public class BlogPostServiceImpl implements BlogPostService {

	/** 블로그 포스팅 repository */
	private BlogPostRepository blogPostRepository;

	@Autowired
	public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
		super();
		this.blogPostRepository = blogPostRepository;
	}

	@Override
	public Optional<BlogPostDto> get(Long id) {
		return this.blogPostRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		Optional<BlogPostDto> blogPostOpt = this.blogPostRepository.findById(id);

		if (blogPostOpt.isPresent()) {
			BlogPostDto blogPostDto = blogPostOpt.get();
			blogPostDto.setUseYN(false);

			this.blogPostRepository.save(blogPostDto);
		} else {
			throw new IllegalArgumentException("블로그 아이디에 해당하는 값을 찾을 수 없습니다.");
		}
	}

	@Override
	public BlogPostDto save(BlogPostDto createModel) {
		return this.blogPostRepository.save(createModel);
	}

	@Override
	public Page<BlogPostDto> getAll(Pageable pageable) {
		return this.blogPostRepository.findAll(pageable);
	}

	@Override
	public Page<BlogPostDto> findByCategoryID(long categoryID, Pageable pageable) {
		return this.blogPostRepository.findByCategoryID(categoryID, pageable);
	}
}
