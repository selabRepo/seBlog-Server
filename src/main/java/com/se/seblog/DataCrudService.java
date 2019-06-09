package com.se.seblog;

import java.util.Optional;

/**
 * 기본 데이터 CRUD를 제공하는 서비스
 * 
 * @author youngjun.jin
 *
 * @param <R> 리턴타입
 * @param <I> 아이디 타입
 * @param <C> 생성객체 타입
 */
public interface DataCrudService<R, I, C> {

	/**
	 * 아이디를 통해 데이터를 반환한다.
	 * 
	 * @author youngjun.jin
	 * @param id 아이디
	 * @return 데이터
	 */
	Optional<R> get(I id);

	/**
	 * 아이디를 통해 데이터를 삭제한다.
	 * 
	 * @author youngjun.jin
	 * @param id 삭제할 아이디
	 */
	void delete(I id);

	/**
	 * 데이터를 추가 또는 업데이트 한다.
	 * 
	 * @author youngjun.jin
	 * @param createModel 생성할 객체
	 * @return 생성된 객체
	 */
	R save(C createModel);
}
