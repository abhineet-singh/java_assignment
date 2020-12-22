package com.training.servlet;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.model.BloodDonor;
import com.training.service.BloodDonorService;
import com.training.utils.DBConnectionUtil;

/**
 * Servlet implementation class BloodDonorServlet
 */
@WebServlet("/donor")
public class BloodDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BloodDonorService donorServ;
	
	private Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BloodDonorServlet() {
        super();  
        this.donorServ = new BloodDonorService();
        this.con = DBConnectionUtil.getMySqlConnection();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BloodDonor> donorList = donorServ.findAll(con);
		
		request.setAttribute("donorList", donorList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("showDonor.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		boolean isAuthenticated = (boolean) session.getAttribute("isAuthenticated");
		System.out.println(isAuthenticated);
		
		if(isAuthenticated) {
		
			String name = request.getParameter("name");
			
			int age = Integer.parseInt(request.getParameter("age"));
			
			String gender = request.getParameter("gender");
			String bloodGroup = request.getParameter("bloodGroup");
			String phoneNumber = request.getParameter("phoneNumber");
			String email = request.getParameter("email");
			
			LocalDate dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth")).toLocalDate();
	
			
			BloodDonor donor = new BloodDonor(name, age, gender, bloodGroup, phoneNumber, email, dateOfBirth);
			System.out.println(donor);
			
			
			Integer rowAdded = donorServ.add(this.con,donor);
			System.out.println(rowAdded);
			
			request.setAttribute("rowAdded", rowAdded);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("input.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		
	}

}
