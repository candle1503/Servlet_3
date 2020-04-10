package com.coupang.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.coupang.point.PointService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		this.memberService = new MemberService();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 Encoding 처리
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
		//PathInfo
			String command = request.getPathInfo();
		//Method 형식
			String method = request.getMethod();
			
		//Forward(true), redirect(false)
			boolean check = true;
			
		//URL 담을 변수
			String path = "";
		try {
		if(command.equals("/memberJoin")) {
			if(method.equals("POST")) {
				
				MemberDTO memberDTO = new MemberDTO();
				
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPassword(request.getParameter("password"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setphone(request.getParameter("phone"));
				memberDTO.setEmail(request.getParameter("email"));
				memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
				int result = memberService.memberJoin(memberDTO);
				
				check = false;
				path="../";
			}else {
				path="../WEB-INF/views/member/memberJoin.jsp";
			}
		}else if(command.equals("/memberLogin")) {
			if(method.equals("POST")) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPassword(request.getParameter("password"));
				memberDTO=memberService.memberLogin(memberDTO);
				
				if(memberDTO != null) {
					HttpSession session = request.getSession();
					session.setAttribute("member", memberDTO);
					check = false;
					path="../";
				}else {
					request.setAttribute("result", "Login Fail");
					request.setAttribute("path", "./memberLogin");
					path="../WEB-INF/views/common/result.jsp";
				}
				
			}else {
				path = "..//WEB-INF/views/member/memberLogin.jsp";
			} 
		} else if (command.equals("/memberLogout")) {
			HttpSession session = request.getSession();
			// session.removeAttribute("member");
			session.invalidate();
			check = false;
			path = "../";
		}else if(command.equals("/memberPage")) {
			path="..//WEB-INF/views/member/memberPage.jsp";
			
		}else if(command.equals("/memberUpdate")) {
			if(method.equals("POST")) {
						
			}else {
				
			}
		}else if(command.equals("/memberDelete")) {
			MemberDTO memberDTO = new MemberDTO();
			HttpSession session = request.getSession();
			memberDTO = (MemberDTO) session.getAttribute("member");
			int result = memberService.memberDelete(memberDTO);
			
			if(result>0) {
				request.setAttribute("result", "Delete!!!");
				request.setAttribute("path", "../");
				path="../WEB-INF/views/common/result.jsp";
				session.invalidate();
			}
			
		}
	}
		catch (Exception e) {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
