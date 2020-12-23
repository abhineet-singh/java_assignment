package com.training.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.model.UserCredit;

/**
 * Servlet implementation class PaymentCheck
 */
@WebServlet("/check")
public class PaymentCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserCredit userCredit;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentCheck() {
        super();
        this.userCredit = new UserCredit();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		
		int planAmt = Integer.parseInt(request.getParameter("plans"));
		
		int isPaymentSuccessful =  this.userCredit.updateCreditLimit(userName, planAmt);
		
		request.setAttribute("creditLimit", this.userCredit.getCreditLimitOfUser(userName));
		
		request.setAttribute("isPaymentSuccessful", isPaymentSuccessful);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("msg.jsp");
		dispatcher.forward(request, response);
	}

}
