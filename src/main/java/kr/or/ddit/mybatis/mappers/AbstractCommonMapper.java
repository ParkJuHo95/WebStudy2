package kr.or.ddit.mybatis.mappers;

import java.util.List;

import kr.or.ddit.common.paging.PaginationInfo;


public interface AbstractCommonMapper<T,P> {
	public int insert(T newData);
	public T select(P pk);
	public int selectTotalRecord(PaginationInfo paging);
	public List<T> selectList(PaginationInfo paging);
	public int update(T target);
	public int delete(P pk);
}
