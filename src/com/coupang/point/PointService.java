package com.coupang.point;

import java.util.ArrayList;

public class PointService {

	private PointDTO pointDTO;
	private PointDAO pointDAO;
	
	public PointService() {
		this.pointDTO = new PointDTO();
		this.pointDAO = new PointDAO(); 
	}
	
	//3. delete
	public PointDTO pointDelete(int num) throws Exception{
		return pointDAO.pointDelete(num);
	}
	
	//2. select
	public PointDTO pointSelect(int num) throws Exception{
		return pointDAO.pointSelect(num);
	}
	
	
	//1. List
	public ArrayList<PointDTO> pointList() throws Exception{
		return pointDAO.pointList();
	}
	
}