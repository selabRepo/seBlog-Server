package com.se.seblog.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.se.seblog.blog.model.entity.BlogPostDto;

/**
 * 블로그 포스트 repository
 * 
 * @author youngjun.jin
 */
@Repository
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

	/**
	 * 작성자 아이디를 통해 작성자의 글 목록을 반환합니다.
	 * 
	 * @param userID 작성자 아이디
	 * @return 작성자 아이디에 해당하는 글 목록
	 */
	@Query("SELECT bp FROM BlogPostDto bp WHERE bp.createdBy = :userID")
	Page<BlogPostDto> findByCreatedBy(String userID, Pageable pageable);
}
