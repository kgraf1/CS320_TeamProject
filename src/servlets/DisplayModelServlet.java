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
		RatingsByModelIdController controller = new RatingsByModelIdController();
		PhysicalModel model = null;
		Profile profile = null;
		List <Keyword> keywords = null;
		List <Material> materials=null;
		Application application = null;
		List <Rating> ratings=null;
		double average;
		int id=0;
		Boolean overview = false;
		Boolean engPrinciple = false;
		Boolean procedure = false;
		Boolean app = false;
		Boolean material = false;
		Boolean rating = false;
		
		
		if(req.getParameter("modelID")!=null) {
			id = Integer.parseInt(req.getParameter("modelID"));
		}
		else if(req.getParameter("overviewModelID")!=null) {
			id = Integer.parseInt(req.getParameter("overviewModelID"));
			overview = true;
		}
		else if (req.getParameter("engPrincipleModelID")!=null) {
			id = Integer.parseInt(req.getParameter("engPrincipleModelID"));
			engPrinciple = true;
		}
		else if (req.getParameter("procedureModelID")!=null) {
			id = Integer.parseInt(req.getParameter("procedureModelID"));
			procedure = true;
		}
		else if (req.getParameter("applicationModelID")!=null) {
			id = Integer.parseInt(req.getParameter("applicationModelID"));
			app = true;
		}
		else if (req.getParameter("materialsModelID")!=null) {
			id = Integer.parseInt(req.getParameter("materialsModelID"));
			material = true;
		}
		else if (req.getParameter("ratingsModelID")!=null) {
			id = Integer.parseInt(req.getParameter("ratingsModelID"));
			rating = true;
		}
		
		
		
	
		db = DatabaseProvider.getInstance();
		model = db.findModelByModelId(id);
		profile = db.findProfileByModelId(id);
		keywords = db.findKeywordsByModelId(id);
		materials = db.findMaterialsByModelId(id);
		application = db.findApplicationByModelId(id);
		ratings = controller.getRatingsByModelId(id);
		average = controller.getAverageByModelId(id);
		
		
		req.setAttribute("model", model);
		req.setAttribute("profile", profile);
		req.setAttribute("keywords", keywords);
		req.setAttribute("materials", materials);
		req.setAttribute("application", application);
		req.setAttribute("ratings", ratings);
		req.setAttribute("average", average);
		
		req.setAttribute("modelId",id);
		
		if(overview == true) {
			req.getRequestDispatcher("/_view/overview.jsp").forward(req, resp);
		}
		else if(engPrinciple == true) {
			req.getRequestDispatcher("/_view/engprinciple.jsp").forward(req, resp);
		}
		else if(procedure == true) {
			req.getRequestDispatcher("_view/procedure.jsp").forward(req, resp);
		}
		else if(app == true) {
			req.getRequestDispatcher("/_view/application.jsp").forward(req, resp);
		}
		else if(material == true) {
			req.getRequestDispatcher("/_view/material.jsp").forward(req, resp);
		}
		else if(rating == true) {
			req.getRequestDispatcher("/_view/rating.jsp").forward(req, resp);
		}
		else {
		req.getRequestDispatcher("/_view/model.jsp").forward(req, resp);
		}
	}
}
