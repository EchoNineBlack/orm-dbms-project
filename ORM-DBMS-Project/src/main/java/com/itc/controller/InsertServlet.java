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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		HttpSession session = request.getSession();
		if (session.getAttribute("loginname") != null) {
			int id = Integer.parseInt(request.getParameter("pid"));
			String pname = request.getParameter("pname");
			String dept = request.getParameter("dept");
			String doctor = request.getParameter("doc");
			Patient pb = new Patient();
			pb.setpId(id);
			pb.setpName(pname);
			pb.setDept(dept);
			pb.setDoctor(doctor);
			PatientDAO pd = new PatientDAO();

			boolean b;

			b = pd.addPatient(pb);
			if (b)
				request.setAttribute("success", "Inserted Successfully");

			else
				request.setAttribute("failure", "Failed To Insert");
			rd.forward(request, response);

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
