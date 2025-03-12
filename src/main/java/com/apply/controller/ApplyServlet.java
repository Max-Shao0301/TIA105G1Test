package com.apply.controller;

import java.io.IOException;

import com.apply.model.ApplyService;
import com.apply.model.ApplyVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ApplyServlet")
public class ApplyServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		
		if ("update".equals(action)) {
			String applyIdStr = req.getParameter("apply_id");
            String resultStr = req.getParameter("results");
            
            System.out.println("apply_id = " + applyIdStr);
            System.out.println("results = " + resultStr);
            // 檢查 apply_id 和 results 是否為有效數字
            if (applyIdStr == null || resultStr == null || applyIdStr.trim().isEmpty() || resultStr.trim().isEmpty()) {
                res.sendError(HttpServletResponse.SC_BAD_REQUEST, "缺少 apply_id 或 results 參數");
                return;
            }
            Integer applyId;
            Integer results;
            try {
                applyId = Integer.parseInt(applyIdStr);
                results = Integer.parseInt(resultStr);
            } catch (NumberFormatException e) {
                res.sendError(HttpServletResponse.SC_BAD_REQUEST, "apply_id 或 results 格式錯誤");
                return;
            }
         // 確保 results 只接受 1（聘用）或 0（婉拒）
            if (results != 1 && results != 0) {
                res.sendError(HttpServletResponse.SC_BAD_REQUEST, "results 參數不合法");
                return;
            }
            
            ApplyService applyService = new ApplyService();
            ApplyVO applyVO = applyService.updateApply(applyId, results);
            
            
            
            /***************************3.修改完成,準備轉交(Send the Success view)*************/
			req.setAttribute("applyVO", applyVO); // 資料庫update成功後,正確的的applyVO物件,存入req
			String url = "/back-end/platform/homepage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交homepage.jsp
			successView.forward(req, res);

		}
		
	}

}
