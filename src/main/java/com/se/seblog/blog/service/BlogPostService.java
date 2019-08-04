package com.se.seblog.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.se.seblog.DataCrudService;
import com.se.seblog.blog.model.entity.BlogPostDto;

/**
 * 블로그 포스팅 서비
 * 
 * @author youngjun.jin
 */
public interface BlogPostService extends DataCrudService<BlogPostDto, Long, BlogPostDto> {

	/**
	 * 페이지 옵션에 해당하는 포스팅 리스트를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @param pageable 페이지 옵션
	 * @return blogPostPages
	 */
	Page<BlogPostDto> getAll(Pageable pageable);
	
	/**
	 * 카테고리 아이디에 해당하는 블로그 목록을 반환합니다.
	 *
	 * @author youngjun.jin
	 * @param categoryID 카테고리 아이디
	 * @param pageable 페이지 옵션
	 * @return 카테고리의 블로그 목록
	 */
	Page<BlogPostDto> findByCategoryID(long categoryID, Pageable pageable);

}
