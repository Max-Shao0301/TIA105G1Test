package com.member.controller;

import java.io.IOException;

import com.member.model.MemberService;
import com.member.model.MemberVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);

	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("delete".equals(action)) {
			String memberIdStr = req.getParameter("member_id");
			System.out.println("member_id = " + memberIdStr);
			if (memberIdStr == null || memberIdStr.trim().isEmpty()) {
				res.sendError(HttpServletResponse.SC_BAD_REQUEST, "缺少member_id參數");
				return;
			}
			Integer memberId;
			try {
				memberId = Integer.parseInt(memberIdStr);
			} catch (NumberFormatException e) {
				res.sendError(HttpServletResponse.SC_BAD_REQUEST, "member_id 格式錯誤");
				return;
			}
			
			MemberService memberService = new MemberService();
			MemberVO memberVO = memberService.deleteMember(memberId);
			
			req.setAttribute("memberVO", memberVO); // 資料庫update成功後,正確的的memberVO物件,存入req
			String url = "/back-end/platform/homepage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交homepage.jsp
			successView.forward(req, res);
		}
	}
}
