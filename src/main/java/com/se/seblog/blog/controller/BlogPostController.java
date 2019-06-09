package com.se.seblog.blog.controller;

import java.util.Optional;

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

import com.se.seblog.blog.model.dto.BlogPostDto;
import com.se.seblog.blog.service.BlogPostService;

/**
 * 블로그 포스팅 컨트롤러
 * 
 * @author youngjun.jin
 */
@RestController
@RequestMapping("/api")
public class BlogPostController {

	/** 블로그 포스팅 서비스 */
	private BlogPostService blogPostService;

	/**
	 * BlogPostController instance를 초기화 합니다.
	 * 
	 * @param blogPostService 블로그 포스팅 서비
	 */
	public BlogPostController(BlogPostService blogPostService) {
		super();
		this.blogPostService = blogPostService;
	}

	/**
	 * [BLOG-01] - 페이지 옵션에 해당하는 블로그 포스팅을 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @param pageable 페이지 옵션
	 * @return 블로그포스트 페이지
	 */
	@GetMapping("/blogs")
	public Page<BlogPostDto> getBlogPosts(Pageable pageable) {

		return this.blogPostService.getAll(pageable);
	}

	/**
	 * [BLOG-02] - 아이디에 해당하는 블로그 포스팅정보를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @param id 포스트 아이디
	 * @return 포스팅 DTO
	 */
	@GetMapping("/blogs/{blogID}")
	public BlogPostDto getBlogPost(@PathVariable(value = "blogID") long id) {

		Optional<BlogPostDto> blogPostOpt = this.blogPostService.get(id);

		if (blogPostOpt.isPresent()) {
			return blogPostOpt.get();
		}
		throw new IllegalArgumentException("블로그 아이디에 해당하는 값을 찾을 수 없습니다.");
	}

	/**
	 * [BLOG-03] - 아이디에 해당하는 포스팅을 제거합니다.
	 * 
	 * @author youngjun.jin
	 * @param id 포스트 아이디
	 * @return "success"
	 */
	@DeleteMapping("/blogs/{blogID}")
	public String deleteBlogPost(@PathVariable(value = "blogID") long id) {

		this.blogPostService.delete(id);
		return "success";
	}

	/**
	 * [BLOG-05] - 블로그를 포스트합니다.
	 * 
	 * @author youngjun.jin
	 * @param blogPostDto 생성할 포스트
	 * @return 생성된 포스트 DTO
	 */
	@PostMapping("/blogs")
	public BlogPostDto postBlogPost(@RequestBody BlogPostDto blogPostDto) {
		return this.blogPostService.save(blogPostDto);
	}

	/**
	 * [BLOG-04] - 아이디에 해당하는 블로그 포스팅을 업데이트 합니다.
	 *
	 * @author youngjun.jin
	 * @param id          업데이트 포스트 아이디
	 * @param blogPostDto 업데이트된 포스트 DTO
	 */
	@PutMapping("/blogs/{blogID}")
	public String updateBlogPost(@PathVariable(value = "blogID") long id, @RequestBody BlogPostDto blogPostDto) {

		Optional<BlogPostDto> blogPostOpt = this.blogPostService.get(id);

		if (blogPostOpt.isPresent()) {
			BlogPostDto blogPost = blogPostOpt.get();
			long targetID = blogPost.getId();

			blogPostDto.setId(targetID);
			this.blogPostService.save(blogPostDto);
			return "success";
		}

		throw new IllegalArgumentException("아이디에 해당하는 블로그 데이터를 찾을 수 없습니다.");
	}

}
