package com.se.seblog;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * 모든 테이블에 필수적으로 필요한 기본 정보 Entity
 * 
 * @author youngjun.jin
 */
@MappedSuperclass
public class BaseEntity {

	/** 데이터 추가 시간 */
	@CreationTimestamp
	@Column(name = "created_date", nullable = false, updatable = false, columnDefinition = "DATETIME")
	private LocalDate createdDate;

	/** 데이터 업데이트 시간 */
	@UpdateTimestamp
	@Column(name = "updated_date", updatable = true, columnDefinition = "DATETIME")
	private LocalDate updatedDate;

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

}
