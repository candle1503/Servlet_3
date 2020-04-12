package com.coupang.board;

import java.util.ArrayList;

public class BoardService {
	private BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}

	//3. Add
	public int boardAdd(BoardDTO boardDTO) throws Exception{
		return boardDAO.boardAdd(boardDTO);
	}
	
	//2. Select
	public BoardDTO boardSelect(int num) throws Exception{
		return boardDAO.boardSelect(num);
	}
	
	//1. list
	public ArrayList<BoardDTO> boardList() throws Exception{
		return boardDAO.boardList();
	}
	
}
