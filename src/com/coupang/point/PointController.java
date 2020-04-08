package com.coupang.point;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 Encoding 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//pathInfo
		String command = request.getPathInfo();
		
		//Method 형식
		String method = request.getMethod();
		
		//Forward(true), redirect(false) 선택
		boolean check = true;
		
		//URL path를 담을 변수
		String path ="";

		if(command.equals("/pointList")) {
			
			
			
			path = "../WEB-INF/views/point/pointList.jsp";
		}else if(command.equals("/pointAdd")) {
			if(method.equals("POST")) {
			}else { 
				path = "../WEB-INF/views/point/pointAdd.jsp";
			}
		}else if(command.equals("/pointMod")) {
			if(method.equals("POST")) {
				
			}else {
				path = "../WEB-INF/views/point/pointMod.jsp";
			}
		}else if(command.equals("/pointSelect")) {
			path = "../WEB-INF/views/point/pointSelect.jsp";
		}else if(command.equals("/pointDelete")) {
		}else {
			System.out.println("ETC");
		}
		
		//
		if(check) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}else {
			response.sendRedirect(path);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
