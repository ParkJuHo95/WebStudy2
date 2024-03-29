package kr.or.ddit.board.service;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.board.exception.BoardException;
import kr.or.ddit.board.exception.WriterAuthenticationException;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.mybatis.mappers.AttatchMapper;
import kr.or.ddit.mybatis.mappers.BoardMapper;
import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardMapper mapper;
	
	@Inject
	private AttatchMapper atchMapper;
	@Value("#{appInfo.boPath}")
	private Resource boPath;
	
	private void processBoFiles(BoardVO board) {
		MultipartFile[] boFiles = board.getBoFiles();
		if(boFiles==null) return;
		for(MultipartFile single : boFiles) {
			if(single.isEmpty()) continue;
			// 파일 메타데이터 저장
			AttatchVO atch = new AttatchVO(single);
			atch.setBoNo(board.getBoNo());
			atchMapper.insertAttatch(atch);
			// 파일 이진데이터 저장
			String saveName = atch.getAttSavename();
			try {
				File saveFile = boPath.createRelative(saveName).getFile();
				FileUtils.copyInputStreamToFile(single.getInputStream(), saveFile);
			}catch (IOException e) {
				throw new UncheckedIOException(e);
			}
		}
	}
	
	@Override
	public void createBoard(BoardVO board) {
		mapper.insert(board);
		processBoFiles(board);
	}

	@Override
	public BoardVO retrieveBoard(int boNo) {
		BoardVO board = mapper.select(boNo);
		if(board==null)
			throw new BoardException(String.format("%d 번 글 없음.", boNo));
		return board;
	}

	@Override
	public List<BoardVO> retrieveBoardList(PaginationInfo paging) {
		int totalRecord = mapper.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return mapper.selectList(paging);
	}

	@Override
	public BoardVO writerAuthenticate(BoardVO target) throws WriterAuthenticationException {
		BoardVO savedBoard = mapper.select(target.getBoNo());
		if(savedBoard==null)
			throw new BoardException(String.format("%d 번 글 없음.", target.getBoNo()));
		String savedPass = savedBoard.getBoPass();
		String inputPass = target.getBoPass();
		if(!savedPass.equals(inputPass))
			throw new WriterAuthenticationException(target.getBoNo());
		return savedBoard;
	}

	@Override
	public void modifyBoard(BoardVO board) {
		writerAuthenticate(board);
		mapper.update(board);
		processBoFiles(board);
	}

	@Override
	public void removeBoard(BoardVO board) {
		writerAuthenticate(board);
		BoardVO saved = mapper.select(board.getBoNo());
		saved.getAttatchList().forEach(a->removeAttatch(a.getAttNo()));
		mapper.delete(board.getBoNo());
	}

	@Override
	public AttatchVO downloadAttatch(int attNo) {
		AttatchVO atch = atchMapper.selectAttatch(attNo);
		if(atch==null)
			throw new BoardException("파일 없음.");
		return atch;
	}

	private void deleteBinary(AttatchVO atch){
		Resource savedBinary;
		try {
			savedBinary = boPath.createRelative(atch.getAttSavename());
			if(savedBinary.exists())
				FileUtils.deleteQuietly(savedBinary.getFile());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	@Override
	public void removeAttatch(int attNo) {
		AttatchVO saved = atchMapper.selectAttatch(attNo);
		atchMapper.deleteAttatch(attNo);
		deleteBinary(saved);
	}
}



















