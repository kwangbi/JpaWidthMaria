package com.kwang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kwang.entity.BoardEntity;
import com.kwang.service.BoardService;

@RestController
@RequestMapping("/api/")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/")
	public String getHello() {
		return "Main Page";
	}
	
	@GetMapping("/board/all")
	public List<BoardEntity> getAllBoardTable(){
		return boardService.getAllBoardList();
	}
	
	@GetMapping("/board/{id}")
	public BoardEntity getByIdBoardTable(@PathVariable String id) {
		return boardService.getByIdBoard(id);
	}
	
	@PostMapping("/board/{id}")
	public BoardEntity updateBoard(@PathVariable String id,@RequestBody BoardEntity boardEntity) {
		return boardService.updateBoard(id, boardEntity);
	}
	
	@PutMapping("/board")
	public BoardEntity insertBoard(@RequestBody BoardEntity boardEntity) {
		return boardService.insertBoard(boardEntity);
	}

	@DeleteMapping("/board/{id}")
	public String deleteBoard(@PathVariable String id) {
		return boardService.deleteBoard(id);
	}
	
}
