package com.se.seblog.blog.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.se.seblog.BaseEntity;

/**
 * 블로그 포스팅 DTO
 * 
 * @author youngjun.jin
 */
@Entity
@Table(name = "post")
public class BlogPostDto extends BaseEntity {

	/**  테이블 아이디*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "BIGINT UNSIGNED")
	private long id;

	/**  카테고리 아이디*/
	@Column(name = "category_id", nullable = false, columnDefinition = "BIGINT UNSIGNED")
	private long categoryID;

	/**  포스팅 제목*/
	@Column(name = "title", nullable = false, updatable=true)
	private String title;

	/** 포스팅 내용*/
	@Column(name = "content", nullable = false, updatable=true)
	private String content;

	/**  조회수*/
	@Column(name = "hits", nullable = false, updatable=true, columnDefinition="BIGINT UNSIGNED")
	private long hits;

	/**  포스팅 노출 여부*/
	@Column(name = "use_yn", nullable = false, updatable=true)
	private boolean useYN;

	/**  작성자명*/
	@Column(name = "created_by", nullable=false, updatable=false)
	private String createdBy;

	/**  user table 아이디*/
	@Column(name = "user_id", nullable = false, updatable = false, columnDefinition = "BIGINT UNSIGNED")
	private long userID;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getHits() {
		return hits;
	}

	public void setHits(long hits) {
		this.hits = hits;
	}

	public boolean isUseYN() {
		return useYN;
	}

	public void setUseYN(boolean useYN) {
		this.useYN = useYN;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

}
