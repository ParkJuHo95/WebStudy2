package kr.or.ddit.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.AttatchVO;

@Mapper
public interface AttatchMapper{
	public int insertAttatch(AttatchVO attatch);
	public AttatchVO selectAttatch(int attNo);
	public int deleteAttatch(int attNo);
}
