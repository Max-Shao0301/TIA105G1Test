package com.staff.controller;

import java.io.IOException;

import com.staff.model.StaffService;
import com.staff.model.StaffVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/StaffServlet")
public class StaffServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);

	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("delete".equals(action)) {
			String staffIdStr = req.getParameter("staff_id");
			System.out.println("staff_id = " + staffIdStr);
			if (staffIdStr == null || staffIdStr.trim().isEmpty()) {
				res.sendError(HttpServletResponse.SC_BAD_REQUEST, "缺少staff_id參數");
				return;
			}
			Integer staffId;
			try {
				staffId = Integer.parseInt(staffIdStr);
			} catch (NumberFormatException e) {
				res.sendError(HttpServletResponse.SC_BAD_REQUEST, "staff_id格式錯誤");
				return;
			}
			StaffService staffService = new StaffService();
			StaffVO staffVO = staffService.deleteStaff(staffId);
			
			req.setAttribute("staffVO", staffVO); // 資料庫update成功後,正確的的memberVO物件,存入req
			String url = "/back-end/platform/homepage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交homepage.jsp
			successView.forward(req, res);
			
		}
	}
	
}
