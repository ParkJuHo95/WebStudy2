package kr.or.ddit.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.BoardVO;

@Mapper
public interface BoardMapper extends AbstractCommonMapper<BoardVO, Integer> {
	
}
