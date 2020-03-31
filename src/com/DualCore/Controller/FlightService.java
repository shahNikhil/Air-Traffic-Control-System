package com.DualCore.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.DualCore.Boundary.FlightImpl;
import com.DualCore.Entity.Flight;

/**
 * Servlet for implementing the Flight with the help of Entity Classes and the DAO
 */
@WebServlet("/FlightService")
public class FlightService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlightService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//Instantiate the Flight DAO
		FlightImpl flightDAO = new FlightImpl();

		//Handle a delete action
		switch(request.getParameter("action")) {
		case "delete" :

			flightDAO.deleteFlight(Integer.parseInt(request.getParameter("id")));

			//redirect the user back to the Flight list
			response.sendRedirect("showFlightsAdmin.jsp");

			break;
			
		case "filter" : 

			String filterName = request.getParameter("'flight_name'");
			flightDAO.showFlightsFilter(filterName);
			
			response.sendRedirect("guestPanel.jsp");
			break;

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		FlightImpl flightDAO = new FlightImpl();

		//Handle an edit action 
		switch(request.getParameter("action")) {
		case "edit" :

			Flight editF = new Flight();

			editF.setId(Integer.parseInt(request.getParameter("id")));
			editF.setPilot_name(request.getParameter("pilot_name"));
			editF.setDep_airport(request.getParameter("dep_airport"));
			editF.setArr_airport(request.getParameter("arr_airport"));
			editF.setManufacturer(request.getParameter("manufacturer"));
			editF.setFlight_name(request.getParameter("flight_name"));
			editF.setDate(request.getParameter("date"));
			editF.setScheduled_time(request.getParameter("scheduled_time"));
			editF.setDelayed_by(Integer.parseInt(request.getParameter("delayed_by")));
			editF.setPriority(Integer.parseInt(request.getParameter("priority")));
			//send the Flight object for edits
			flightDAO.updateFlight(editF);

			//redirect the user back to the Flight list
			response.sendRedirect("showFlightsAdmin.jsp");

			break;

		case "create" :

			//Make a new Flight
			Flight createF = new Flight();

			createF.setPilot_name(request.getParameter("pilot_name"));
			createF.setDep_airport(request.getParameter("dep_airport"));
			createF.setArr_airport(request.getParameter("arr_airport"));
			createF.setManufacturer(request.getParameter("manufacturer"));
			createF.setFlight_name(request.getParameter("flight_name"));
			createF.setDate(request.getParameter("date"));
			createF.setScheduled_time(request.getParameter("scheduled_time"));
			createF.setDelayed_by(Integer.parseInt(request.getParameter("delayed_by")));
			createF.setPriority(Integer.parseInt(request.getParameter("priority")));

			//send the Flight back to add in the list
			int newId = flightDAO.newFlight(createF);

			//redirect the user back to the Flight list
			response.sendRedirect("showFlightsAdmin.jsp");

			break;

		}

	}

}