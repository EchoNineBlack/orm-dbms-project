package com.itc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itc.dao.DoctorDAO;
import com.itc.model.Doctor;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("did"));
		String dname = request.getParameter("dname");

		Doctor db = new Doctor();

		db.setdId(id);
		db.setdName(dname);

		DoctorDAO dd = new DoctorDAO();

		String name = dd.loginCheck(db);
		if (name != null) {
			session.setAttribute("loginname", name);
			response.sendRedirect("menu.jsp");
		} else {
			request.setAttribute("error", "Invalid Login");
			rd.forward(request, response);
		}
	}
}
