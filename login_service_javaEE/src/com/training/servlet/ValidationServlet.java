package com.training.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.model.User;
import com.training.service.Validator;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/valid")
public class ValidationServlet extends HttpServlet {
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy called ");
	}

	@Override
	public void init() throws ServletException {	
		super.init();
		System.out.println("init called ");
	}

	private Validator validator;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationServlet() {
        super();
        this.validator = new Validator();
        
        System.out.println("constructor called ");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		User user = new User(userName, password, role);		
		System.out.println(user);

		boolean isValidUser = validator.validate(user);		
		System.out.println(isValidUser);
		
		RequestDispatcher dispatcher;
		
		if(isValidUser) {			
			dispatcher = request.getRequestDispatcher("success.jsp");		
		}
		else {
			dispatcher = request.getRequestDispatcher("failure.jsp");
		}

		dispatcher.forward(request, response);	
	}

}
