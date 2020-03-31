package com.DualCore.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DualCore.Boundary.PilotImpl;
import com.DualCore.Entity.Pilot;

/**
 * Servlet for implementing the Pilot with the help of Entity Classes and the DAO
 */
@WebServlet("/PilotService")
public class PilotService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PilotService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//Instantiate The Pilot DAO
		PilotImpl pilotDAO = new PilotImpl();

		//Handle a delete action
		switch (request.getParameter("action")) {
		case "delete":
			pilotDAO.deletePilot(Integer.parseInt(request.getParameter("id")));

			//redirect the user back to the pilot list
			response.sendRedirect("showPilotsAdmin.jsp");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PilotImpl pilotDAO = new PilotImpl();
		
		//Handle an edit action
		switch(request.getParameter("action")) {
			case "edit" : 
				Pilot editP = new Pilot();
				
				editP.setId(Integer.parseInt(request.getParameter("id")));
				editP.setFirst_name(request.getParameter("first_name"));
				editP.setLast_name(request.getParameter("last_name"));
				editP.setAge(Integer.parseInt(request.getParameter("age")));
				editP.setGender(request.getParameter("gender"));
				editP.setNationality(request.getParameter("nationality"));
				editP.setTraining_level(Integer.parseInt(request.getParameter("training_level")));
				
				//send the pilot object for edits
				pilotDAO.updatePilot(editP);
				
				//redirect the user back to the pilot list
				response.sendRedirect("showPilotsAdmin.jsp");
				break;
				
			case "create" :
				//Make a new Pilot
				Pilot createP = new Pilot();
				
				createP.setFirst_name(request.getParameter("first_name"));
				createP.setLast_name(request.getParameter("last_name"));
				createP.setAge(Integer.parseInt(request.getParameter("age")));
				createP.setGender(request.getParameter("gender"));
				createP.setNationality(request.getParameter("nationality"));
				createP.setTraining_level(Integer.parseInt(request.getParameter("training_level")));

				//send the student back to add in the list
				int newId = pilotDAO.newPilot(createP);
				
				//redirect the user back to the Pilot list
				response.sendRedirect("showPilotsAdmin.jsp");
				
				break;
		}
		
	}

}
