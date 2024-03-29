package kr.or.ddit.board.dao;

import kr.or.ddit.mybatis.mappers.BoardMapper;
import kr.or.ddit.vo.BoardVO;

public interface BoardDAO extends BoardMapper{
	public int insertBoard(BoardVO board);
}
