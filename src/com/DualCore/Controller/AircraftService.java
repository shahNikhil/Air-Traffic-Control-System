package com.DualCore.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DualCore.Boundary.AircraftImpl;
import com.DualCore.Entity.Aircraft;

/**
 * Servlet for implementing the Aircraft with the help of Entity Classes and the DAO
 */
@WebServlet("/AircraftService")
public class AircraftService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AircraftService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//Instantiate the Aircraft DAO
		AircraftImpl aircraftDAO = new AircraftImpl();

		//Handle a delete action
		switch(request.getParameter("action")) {
		case "delete" :

			aircraftDAO.deleteAircraft(Integer.parseInt(request.getParameter("id")));

			//redirect the user back to the Aircraft list
			response.sendRedirect("showAircrafts.jsp");

			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		AircraftImpl aircraftDAO = new AircraftImpl();

		//Handle an edit action 
		switch(request.getParameter("action")) {
		case "edit" :

			Aircraft editA = new Aircraft();
				//manufacturer, total_seats, weight_capacity, is_autoPilot, max_speed)
			editA.setId(Integer.parseInt(request.getParameter("id")));
			editA.setManufacturer(request.getParameter("manufacturer"));
			editA.setTotal_seats(request.getParameter("total_seats"));
			editA.setWeight_capacity(request.getParameter("weight_capacity"));
			editA.setIs_autoPilot(request.getParameter("is_autoPilot"));
			editA.setMax_speed(request.getParameter("max_speed"));

			//send the Aircraft object for edits
			aircraftDAO.updateAircraft(editA);

			//redirect the user back to the Aircraft list
			response.sendRedirect("showAircrafts.jsp");

			break;

		case "create" :

			//Make a new Aircraft
			Aircraft createA = new Aircraft();

			createA.setManufacturer(request.getParameter("manufacturer"));
			createA.setTotal_seats(request.getParameter("total_seats"));
			createA.setWeight_capacity(request.getParameter("weight_capacity"));
			createA.setIs_autoPilot(request.getParameter("is_autoPilot"));
			createA.setMax_speed(request.getParameter("max_speed"));

			//send the Aircraft back to add in the list
			int newId = aircraftDAO.newAircraft(createA);

			//redirect the user back to the Aircraft list
			response.sendRedirect("showAircrafts.jsp");

			break;
		}

	}

}