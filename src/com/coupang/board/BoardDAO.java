package com.coupang.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.coupang.util.DBConnector;

public class BoardDAO {

	
	//2. boardSelect
	public BoardDTO boardSelect(int num) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "select * from board where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		BoardDTO boardDTO = new BoardDTO();
		if(rs.next()) {
			boardDTO.setNum(rs.getInt("num"));
			boardDTO.setSubject(rs.getString("subject"));
			boardDTO.setId(rs.getString("id"));
			boardDTO.setCreatDate(rs.getDate("creatDate"));
			boardDTO.setHit(rs.getInt("hit"));
		}
		
		st.close();
		con.close();
		
		return boardDTO;
	}
	
	//1. boardList
	public ArrayList<BoardDTO> boardList() throws Exception {
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		Connection con = DBConnector.getConnection();
		
		String sql = "Select * from board order by num asc";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getInt("num"));
			boardDTO.setSubject(rs.getString("subject"));
			boardDTO.setId(rs.getString("id"));
			boardDTO.setCreatDate(rs.getDate("creatDate"));
			boardDTO.setHit(rs.getInt("hit"));
			ar.add(boardDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
}
