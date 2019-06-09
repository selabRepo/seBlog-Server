package com.se.seblog.blog.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.se.seblog.BaseEntity;

/**
 * 카테고리 DTO
 * 
 * @author youngjun.jin
 */
@Entity
@Table(name = "category")
public class CategoryDto extends BaseEntity {

	/** 아이디 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
	private long id;

	/** 카테고리 명 */
	@Column(name = "name", nullable = false, updatable = true)
	private String categoryName;

	/** 그룹 번호 */
	@Column(name = "group_nember", nullable = false, updatable = true)
	private int groupNumber;

	/** 카테고리 depth */
	@Column(name = "depth", nullable = false, updatable = true)
	private int depth;

	/** 카테고리 그룹순서 */
	@Column(name = "group_order", nullable = false, updatable = true)
	private int groupOrder;

	/** 생성한 사람 */
	@Column(name = "created_by", nullable = false, updatable = false)
	private String createdBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getGroupOrder() {
		return groupOrder;
	}

	public void setGroupOrder(int groupOrder) {
		this.groupOrder = groupOrder;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
