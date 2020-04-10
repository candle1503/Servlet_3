package com.coupang.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.coupang.util.DBConnector;

public class MemberDAO {


	
	//4. memberUpdate
		public int memberUpdate(MemberDTO memberDTO) throws Exception{
			int result =0;
			
			Connection con = DBConnector.getConnection();
			
			String sql = "update member set name=?, phone=?, email=?, age=? where id=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, memberDTO.getName());
			st.setString(2, memberDTO.getphone());
			st.setString(3, memberDTO.getEmail());
			st.setInt(4, memberDTO.getAge());
			st.setString(5, memberDTO.getId());
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
			return result;
		}

	//3. memberDelete
		public int memberDelete(MemberDTO memberDTO) throws Exception{
			
			Connection con = DBConnector.getConnection();
			
			String sql = "delete from member where id=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, memberDTO.getId());
			
			int result = st.executeUpdate();
			
			st.close();
			con.close();
			
			return result;
			
		}

	//2. memberLogin
		
		public MemberDTO memberLogin(MemberDTO memberDTO)throws Exception{
			
			Connection con  = DBConnector.getConnection();
			String sql ="select * from member where id=? and password=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			st.setString(2, memberDTO.getPassword());
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				memberDTO.setName(rs.getString("name"));
				memberDTO.setEmail(rs.getString("email"));
				memberDTO.setphone(rs.getString("phone"));
				memberDTO.setAge(rs.getInt("age"));
			}else {
				memberDTO = null;
			}
			
			rs.close();
			st.close();
			con.close();
			
			return memberDTO;
			
		}
	
	
	
	//1. memberJoin
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "insert into member values(?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPassword());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getphone());
		st.setString(5, memberDTO.getEmail());
		st.setInt(6, memberDTO.getAge());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
}
