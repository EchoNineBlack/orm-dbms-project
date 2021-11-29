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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/delete.jsp");
		HttpSession session = request.getSession();
		if (session.getAttribute("loginname") != null) {
			int id = Integer.parseInt(request.getParameter("pid"));
			Patient pb = new Patient();
			pb.setpId(id);
			PatientDAO pd = new PatientDAO();

			boolean b;

			b = pd.deletePatient(pb);
			if (b)
				request.setAttribute("success", "Deleted Successfully");

			else
				request.setAttribute("failure", "Failed To Delete");
			rd2.forward(request, response);

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
