package com.kwang.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.kwang.entity.BoardEntity;
import com.kwang.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	
	private final BoardRepository boardRepository;
	
	public List<BoardEntity> getAllBoardList() {
		return boardRepository.findAll();
	}
	
	public BoardEntity getByIdBoard(String id) {
		
		try {
			Long boardId = Long.parseLong(id);
			
			Optional<BoardEntity> boardEntity = boardRepository.findById(boardId);
			
			if(boardEntity.isPresent()) {
				return boardEntity.get();	
			}else {
				return null;
			}
		}catch(Exception e) {
			return null;
		}
		
	}
	
	@Transactional
	public BoardEntity updateBoard(String id, BoardEntity ReqEntity) {
		
		try {
			Long boardId = Long.parseLong(id);
			
			Optional<BoardEntity> boardEntity = boardRepository.findById(boardId);
			
			if(boardEntity.isPresent()) {
				boardEntity.get().setTitle(ReqEntity.getTitle());
				boardEntity.get().setContents(ReqEntity.getContents());
				boardRepository.save(boardEntity.get());
				return boardEntity.get();
			}else {
				return null;
			}
		}catch(Exception e) {
			return null;
		}
	}
	
	@Transactional
	public BoardEntity insertBoard(BoardEntity boardEntity) {
		return boardRepository.save(boardEntity);
	}

	@Transactional
	public String deleteBoard(String id) {
		
		try {
			Long boardId = Long.parseLong(id);
			boardRepository.deleteById(boardId);
			return "Delete Success!";
		}catch(Exception e) {
			return "Delete Failed!";
		}
	}
	
}
