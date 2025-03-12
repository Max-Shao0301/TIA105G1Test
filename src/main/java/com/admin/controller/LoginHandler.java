package com.admin.controller;

import java.io.IOException;

import com.admin.model.AdminService;
import com.admin.model.AdminVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	private AdminService adminService = new AdminService();

	protected boolean allowUser(String account, String password) {
		AdminVO adminVO = adminService.findByAccount(password);
//		AdminVO adminVO = adminService.getOneAdmin(1);
		
		if(adminVO != null && adminVO.getAccount().equals(account) && adminVO.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

// 取得使用者 帳號(account) 密碼(password)
		String account = req.getParameter("account");
		String password = req.getParameter("password");

// 檢查該帳號 , 密碼是否有效
		if (!allowUser(account, password)) { // 帳號 , 密碼無效時
			req.setAttribute("errorMessage", "帳號或密碼錯誤！");
			req.getRequestDispatcher("/back-end/platform/login.jsp").forward(req, res);
			return;

		} else { // 帳號 , 密碼有效時, 才做以下工作
			HttpSession session = req.getSession();
			session.setAttribute("account", account); // *工作1: 才在session內做已經登入過的標識

			try {
				String location = (String) session.getAttribute("location");
				if (location != null) {
					session.removeAttribute("location"); // *工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
					res.sendRedirect(location);
					return;
				}
			} catch (Exception ignored) {}

			res.sendRedirect(req.getContextPath() + "/back-end/platform/homepage.jsp"); // *工作3: (-->如無來源網頁:則重導至login_success.jsp)
		}
	}
}
