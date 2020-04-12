package com.coupang.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coupang.member.MemberDTO;
import com.coupang.point.PointService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        this.boardService = new BoardService();
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
		
		//URL path 담을 변수
		String path = "";
		
		try {
		if(command.equals("/boardList")) {
			ArrayList<BoardDTO> ar = boardService.boardList();
			request.setAttribute("list", ar);
			path = "../WEB-INF/views/board/boardList.jsp";
		}else if(command.equals("/boardSelect")) {
			int num = Integer.parseInt(request.getParameter("num"));
			BoardDTO boardDTO = boardService.boardSelect(num);
			
			request.setAttribute("dto", boardDTO);
			
			path = "../WEB-INF/views/board/boardSelect.jsp";
//		}else if(command.equals("/boardAdmin")){
//			HttpSession session = request.getSession();
//			MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
//			
//			if(memberDTO.getId().equals("admin")){
//				path="./boardAdd";
//			}else {
//				path="../WEB-INF/views/common/result.jsp";
//				request.setAttribute("result", "관리자만 가능합니다");
//				request.setAttribute("path", "../");
//			}
		}else if(command.equals("/boardAdd")) {
			if(method.equals("POST")) {
				BoardDTO boardDTO = new BoardDTO();
				HttpSession session = request.getSession();
				MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
				boardDTO.setId(memberDTO.getId());
				String text = request.getParameter("text");
				String subject = request.getParameter("subject");
				boardDTO.setSubject(subject);
				boardDTO.setText(text);
				
				int result = boardService.boardAdd(boardDTO);
				if(result>0) {
					path="../WEB-INF/views/common/result.jsp";
					request.setAttribute("path", "../");
					request.setAttribute("result", "게시물 추가 완료");
				}
				
			}else {
				path="../WEB-INF/views/board/boardAdd.jsp";
			}
		}else if(command.equals("/boardDelete")) {
			
		}
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}
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
