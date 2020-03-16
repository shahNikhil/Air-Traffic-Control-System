package com.DualCore.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DualCore.Boundary.AirportImpl;
import com.DualCore.Entity.Airport;

/**
 *  Servlet for implementing the Airport with the help of Entity Classes and the DAO
 */
@WebServlet("/AirportService")
public class AirportService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AirportService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//Instantiate the Airport DAO
		AirportImpl airportDAO = new AirportImpl();

		//Handle a delete action
		switch(request.getParameter("action")) {
		case "delete" :

			airportDAO.deleteAirport(Integer.parseInt(request.getParameter("id")));

			//redirect the user back to the airport list
			response.sendRedirect("showAirports.jsp");

			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		AirportImpl airportDAO = new AirportImpl();

		//Handle an edit action 
		switch(request.getParameter("action")) {
		case "edit" :

			Airport editA = new Airport();

			editA.setId(Integer.parseInt(request.getParameter("id")));
			editA.setCountry(request.getParameter("country"));
			editA.setCity(request.getParameter("city"));
			editA.setAirport_name(request.getParameter("airport_name"));
			editA.setAirport_type(request.getParameter("airport_type"));
			editA.setTotal_runways(Integer.parseInt(request.getParameter("total_runways")));
			editA.setTotal_terminals(Integer.parseInt(request.getParameter("total_terminals")));

			//send the airport object for edits
			airportDAO.updateAirport(editA);

			//redirect the user back to the Airport list
			response.sendRedirect("showAirports.jsp");

			break;

		case "create" :

			//Make a new Airport
			Airport createA = new Airport();

			createA.setCountry(request.getParameter("country"));
			createA.setCity(request.getParameter("city"));
			createA.setAirport_name(request.getParameter("airport_name"));
			createA.setAirport_type(request.getParameter("airport_type"));
			createA.setTotal_runways(Integer.parseInt(request.getParameter("total_runways")));
			createA.setTotal_terminals(Integer.parseInt(request.getParameter("total_terminals")));

			//send the airport back to add in the list
			int newId = airportDAO.newAirport(createA);

			//redirect the user back to the Airport list
			response.sendRedirect("showAirports.jsp");

			break;
		}

	}

}