package com.coupang.board;

import java.util.ArrayList;

public class BoardService {
	private BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}


	//5. Mod
	public int boardMod(BoardDTO boardDTO) throws Exception{
		return boardDAO.boardMod(boardDTO);
	}
	
	//4. delete
	public int boardDelete(String num) throws Exception{
		return boardDAO.boardDelete(num);
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
