package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.RatingsByModelIdController;
import model.Application;
import model.Keyword;
import model.Material;
import model.PhysicalModel;
import model.Profile;
import model.Rating;
import persist.DatabaseProvider;
import persist.IDatabase;

public class HomepageServlet extends HttpServlet{
private static final long serialVersionUID = 1L;

	
	@Override 
	protected void doGet (HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		System.out.println("\n HomepageServlet: doGet");
		
		req.getRequestDispatcher("/_view/homepage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		
		System.out.println("\n	SearchServlet: doPost");
		
		req.getRequestDispatcher("/_view/homepage.jsp").forward(req, resp);
	}
}
