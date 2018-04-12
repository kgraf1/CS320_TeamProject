package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Application;
import model.Keyword;
import model.Material;
import model.PhysicalModel;
import model.Rating;
import persist.DatabaseProvider;
import persist.IDatabase;

public class DisplayModelServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IDatabase db = null;
	
	@Override 
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		System.out.println("\n DisplayModelServlet: doGet");
		
		req.getRequestDispatcher("/_view/model.jsp").forward(req, resp);
		
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		System.out.println("\n DisplayModelServlet: doPost");
		
		PhysicalModel model = null;
		List <Keyword> keywords = null;
		List <Material> materials=null;
		Application application = null;
		List <Rating> ratings=null;
		
		int id = Integer.parseInt(req.getParameter("modelID"));
	
		
		db = DatabaseProvider.getInstance();
		model = db.findModelByModelId(id);
		keywords = db.findKeywordsByModelId(id);
		materials = db.findMaterialsByModelId(id);
		application = db.findApplicationByModelId(id);
		ratings = db.findRatingsByModelId(id);
		
		req.setAttribute("model", model);
		req.setAttribute("keywords", keywords);
		req.setAttribute("materials", materials);
		req.setAttribute("application", application);
		req.setAttribute("rating", ratings);
		
		req.getRequestDispatcher("/_view/model.jsp").forward(req, resp);
	}
}