package com.coupang.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.coupang.util.DBConnector;

public class BoardDAO {

	
	//5. boardMod
	public int boardMod(BoardDTO boardDTO) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "update board SET num = ?, subject=?,text=?,id=?,creatdate=sysdate,hit=?  where num = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, boardDTO.getNum());
		st.setString(2, boardDTO.getSubject());
		st.setString(3, boardDTO.getText());
		st.setString(4, boardDTO.getId());
		st.setInt(5, 1);
		st.setInt(6, boardDTO.getNum());
		
		int result = st.executeUpdate();
		
		return result;
	}
	
	
	//4. boardDelete
	public int boardDelete(String num) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "delete board where num = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, num);
		
		int result = st.executeUpdate();
		
		return result;
	}
	
	//3. boardAdd
	public int boardAdd(BoardDTO boardDTO) throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql = "insert into board values(count.NEXTVAL,?,?,?,sysdate,1)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, boardDTO.getSubject());
		st.setString(2, boardDTO.getText());
		st.setString(3, boardDTO.getId());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
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
			boardDTO.setText(rs.getString("text"));
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
