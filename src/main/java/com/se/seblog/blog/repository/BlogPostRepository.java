package com.se.seblog.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.se.seblog.blog.model.entity.BlogPostDto;

/**
 * 블로그 포스트 repository
 * 
 * @author youngjun.jin
 */
public interface BlogPostRepository extends JpaRepository<BlogPostDto, Long> {
	
	/**
	 * 카테고리 아이디에 해당하는 블로그 목록을 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @param categoryID 카테고리 아이디
	 * @param pageable 페이지 옵션
	 * @return 카테고리 아이디에 해당하는 블로그 목록
	 */
	@Query("SELECT bp FROM BlogPostDto bp "
			+ " INNER JOIN "
			+ " CategoryDto c "
			+ " ON c.id = bp.categoryID "
			+ " WHERE c.id = :categoryID ")
	Page<BlogPostDto> findByCategoryID(long categoryID, Pageable pageable);
}
