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
		
		if(this.userCredit.getUserCreditMap().containsKey(userName)) {
		
			int currentLimitOfUser =  this.userCredit.getUserCreditMap().get(userName);
			
			System.out.println(currentLimitOfUser);
			
			if(currentLimitOfUser >= planAmt) {
				
				request.setAttribute("isPaymentSuccessful", 1);
				
				currentLimitOfUser -= planAmt;
				
				this.userCredit.getUserCreditMap().replace(userName, currentLimitOfUser);	
			}
			else {
				
				request.setAttribute("isPaymentSuccessful", 0);			
			}
			
			request.setAttribute("creditLimit", currentLimitOfUser);
		}
		else {
			request.setAttribute("isPaymentSuccessful", -1);	
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("msg.jsp");
		dispatcher.forward(request, response);
	}

}
