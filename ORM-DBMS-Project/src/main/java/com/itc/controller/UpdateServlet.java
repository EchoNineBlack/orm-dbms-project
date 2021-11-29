package com.itc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itc.dao.PatientDAO;
import com.itc.model.Patient;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginname") != null) {
			RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/ViewServlet");
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");

			int id = Integer.parseInt(request.getParameter("pid"));
			String name = request.getParameter("pname");
			String dep = request.getParameter("dept");
			String doc = request.getParameter("doctor");

			Patient eb = new Patient();
			eb.setpId(id);
			eb.setpName(name);
			eb.setDept(dep);
			eb.setDoctor(doc);

			PatientDAO ed = new PatientDAO();

			boolean b = ed.updatePatient(eb);
			if (b)
				rd2.forward(request, response);
			else {
				request.setAttribute("failure", "Failed To Update");
				rd.forward(request, response);
			}
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
