package com.shoppingcartlist.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingcartlist.model.ShoppingcartlistService;
import com.shoppingcartlist.model.ShoppingcartlistVO;

public class ShoppingcartlistServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("shoppingcartListNo");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入購物車清單編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/shoppingcartlist/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				Integer shoppingcartListNo = null;
				try {
					shoppingcartListNo = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("購物車清單編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/shoppingcartlist/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				/***************************2.開始查詢資料*****************************************/
				ShoppingcartlistService shoppingcartlistSvc = new ShoppingcartlistService();
				ShoppingcartlistVO shoppingcartlistVO = shoppingcartlistSvc.getOneShoppingcartlist(shoppingcartListNo);
				if (shoppingcartlistVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/shoppingcartlist/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
		
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("shoppingcartlistVO", shoppingcartlistVO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/shoppingcartlist/listOneShoppingcartlist.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數****************************************/
				Integer shoppingcartListNo= Integer.valueOf(req.getParameter("shoppingcartListNo"));
		
				/***************************2.開始查詢資料****************************************/
				ShoppingcartlistService shoppingcartlistSvc = new ShoppingcartlistService();
				ShoppingcartlistVO shoppingcartlistVO = shoppingcartlistSvc.getOneShoppingcartlist(shoppingcartListNo);
		
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("shoppingcartlistVO",shoppingcartlistVO);         // 資料庫取出的empVO物件,存入req
				String url = "/back-end/shoppingcartlist/update_shoppingcartlist_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer shoppingcartListNo = Integer.valueOf(req.getParameter("shoppingcartListNo").trim());

				Integer memNo = Integer.valueOf(req.getParameter("memNo").trim());

				Integer goodsNo = Integer.valueOf(req.getParameter("goodsNo").trim());

				Integer goodsNum = Integer.valueOf(req.getParameter("goodsNum").trim());

				Integer goodsPrice = Integer.valueOf(req.getParameter("goodsPrice").trim());
				
				String goodsName = req.getParameter("goodsName");
				String goodsNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_\\s)]{2,10}$";
				if (goodsName == null || goodsName.trim().length() == 0) {
				    errorMsgs.add("商品名稱: 請勿空白");
				} else if (!goodsName.trim().matches(goodsNameReg)) { //以下練習正則(規)表示式(regular-expression)
				    errorMsgs.add("商品名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}


				Integer orderTotalprice = Integer.valueOf(req.getParameter("orderTotalprice").trim());

				
				ShoppingcartlistVO shoppingcartlistVO = new ShoppingcartlistVO();
				shoppingcartlistVO.setShoppingcartListNo(shoppingcartListNo);
				shoppingcartlistVO.setMemNo(memNo);
				shoppingcartlistVO.setGoodsNo(goodsNo);
				shoppingcartlistVO.setGoodsNum(goodsNum);
				shoppingcartlistVO.setGoodsPrice(goodsPrice);
				shoppingcartlistVO.setGoodsName(goodsName);
				shoppingcartlistVO.setOrderTotalprice(orderTotalprice);
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
req.setAttribute("shoppingcartlistVO", shoppingcartlistVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/shoppingcartlist/update_shoppingcartlist_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				ShoppingcartlistService shoppingcartlistSvc = new ShoppingcartlistService();
				shoppingcartlistVO = shoppingcartlistSvc.updateShoppingcartlist(
						shoppingcartListNo, memNo, goodsNo, goodsNum, goodsPrice, goodsName, orderTotalprice);


				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("shoppingcartlistVO", shoppingcartlistVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/back-end/shoppingcartlist/listOneShoppingcartlist.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}
        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);	
			
			
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				Integer memNo = Integer.valueOf(req.getParameter("memNo").trim());
	
				Integer goodsNo = Integer.valueOf(req.getParameter("goodsNo").trim());
	
				Integer goodsNum = Integer.valueOf(req.getParameter("goodsNum").trim());
	
				Integer goodsPrice = Integer.valueOf(req.getParameter("goodsPrice").trim());
	

				String goodsName = req.getParameter("goodsName");
				String goodsNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_\\s)]{2,10}$";
				if (goodsName == null || goodsName.trim().length() == 0) {
				    errorMsgs.add("商品名稱: 請勿空白");
				} else if (!goodsName.trim().matches(goodsNameReg)) { //以下練習正則(規)表示式(regular-expression)
				    errorMsgs.add("商品名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}
				
				Integer orderTotalprice = Integer.valueOf(req.getParameter("orderTotalprice").trim());
				
				ShoppingcartlistVO shoppingcartlistVO = new ShoppingcartlistVO();
				shoppingcartlistVO.setMemNo(memNo);
				shoppingcartlistVO.setGoodsNo(goodsNo);
				shoppingcartlistVO.setGoodsNum(goodsNum);
				shoppingcartlistVO.setGoodsPrice(goodsPrice);
				shoppingcartlistVO.setGoodsName(goodsName);
				shoppingcartlistVO.setOrderTotalprice(orderTotalprice);
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
req.setAttribute("shoppingcartlistVO", shoppingcartlistVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/shoppingcartlist/addShoppingcartlist.jsp");
					failureView.forward(req, res);
					return;
				}
				/***************************2.開始新增資料***************************************/
				ShoppingcartlistService shoppingcartlistSvc = new ShoppingcartlistService();
				shoppingcartlistVO = shoppingcartlistSvc.addShoppingcartlist(memNo, goodsNo, goodsNum, goodsPrice, goodsName, orderTotalprice);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/shoppingcartlist/listAllShoppingcartlist.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
        		}
        
				if ("delete".equals(action)) { // 來自listAllEmp.jsp

					List<String> errorMsgs = new LinkedList<String>();
					// Store this set in the request scope, in case we need to
					// send the ErrorPage view.
					req.setAttribute("errorMsgs", errorMsgs);
					/***************************1.接收請求參數***************************************/
					Integer shoppingcartListNo = Integer.valueOf(req.getParameter("shoppingcartListNo"));
					/***************************2.開始刪除資料***************************************/
					ShoppingcartlistService managerSvc = new ShoppingcartlistService();
					managerSvc.deleteShoppingcartlist(shoppingcartListNo);
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
					String url = "/back-end/shoppingcartlist/listAllShoppingcartlist.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);
		}
	}
}

