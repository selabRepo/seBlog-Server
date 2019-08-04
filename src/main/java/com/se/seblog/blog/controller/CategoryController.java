package com.se.seblog.blog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.seblog.blog.model.entity.BlogPostDto;
import com.se.seblog.blog.model.entity.CategoryDto;
import com.se.seblog.blog.service.BlogPostService;
import com.se.seblog.blog.service.CategoryService;

/**
 * category 컨트롤러
 * 
 * @author youngjun.jin
 */
@RestController
@RequestMapping("/api")
public class CategoryController {

	/** category Service */
	private CategoryService categoryService;

	/** blogPost Service */
	private BlogPostService blogPostService;

	/**
	 * CategoryController instance를 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param categoryService categoryService
	 */
	@Autowired
	public CategoryController(CategoryService categoryService, BlogPostService blogPostService) {
		super();
		this.categoryService = categoryService;
		this.blogPostService = blogPostService;
	}

	/**
	 * [CATEGORY-01] - 전체 카테고리 리스트를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return 전체 카테고리 리스트
	 */
	@GetMapping(value = "/categories")
	public Page<CategoryDto> getCategorys() {
		return this.categoryService.getAll(Pageable.unpaged());
	}

	/**
	 * [CATEGORY-02] - 아이디를 통해 카테고리 정보를 반환합니다.
	 *
	 * @author youngjun.jin
	 * @param id 카테고리 아이디
	 * @return 카테고리
	 */
	@GetMapping(value = "/categories/{categoryID}")
	public CategoryDto getCategory(@PathVariable("categoryID") long id) {
		Optional<CategoryDto> categoryOpt = this.categoryService.get(id);

		if (categoryOpt.isPresent()) {
			return categoryOpt.get();
		}
		throw new IllegalArgumentException("TODO");
	}

	/**
	 * [CATEGORY-03] - 카테고리 아이디에 해당하는 블로그 목록을 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @param id       카테고리 아이디
	 * @param pageable 페이지 옵션
	 * @return 카테고리의 블로그목록
	 */
	@GetMapping(value = "/categories/{categoryID}/blogs")
	public Page<BlogPostDto> getBlogsOfCategory(@PathVariable("categoryID") long id, Pageable pageable) {
		return this.blogPostService.findByCategoryID(id, pageable);
	}

	/**
	 * [CATEGORY-05] - 카테고리를 추가합니다.
	 * 
	 * @author youngjun.jin
	 * @param categoryDto 추가할 카테고리 정보
	 * @return 생성된 카테고리
	 */
	@PostMapping(value = "/categories")
	public CategoryDto addCategory(@RequestBody CategoryDto categoryDto) {
		return this.categoryService.save(categoryDto);
	}

	/**
	 * [CATEGORY-06] - 카테고리 아이디에 해당하는 카테고리 정보를 수정합니다.
	 * 
	 * @author youngjun.jin
	 * @param id          카테고리 아이디
	 * @param categoryDto 수정할 카테고리 정보
	 * @return 
	 */
	@PutMapping(value = "/categories/{categoryID}")
	public String updateCategory(@PathVariable("categoryID") long id, @RequestBody CategoryDto categoryDto) {
		Optional<CategoryDto> categoryOpt = this.categoryService.get(id);

		if (categoryOpt.isPresent()) {
			CategoryDto category = categoryOpt.get();
			long targetID = category.getId();
			categoryDto.setId(targetID);

			this.categoryService.save(categoryDto);
			return "success";
		} 
		throw new IllegalArgumentException("카테고리 아이디에 해당하는 카테고리 정보를 찾을 수 없습니다.");
	}

	/**
	 * [CATEGORY-04] - 아이디를 통해 카테고리를 제거합니다.
	 * 
	 * @author youngjun.jin
	 * @param id 카테고리 아이디
	 * @return "success"
	 */
	@DeleteMapping(value = "/categories/{categoryID}")
	public String deleteCategory(@PathVariable("categoryID") long id) {
		this.categoryService.delete(id);
		return "success";
	}
}
