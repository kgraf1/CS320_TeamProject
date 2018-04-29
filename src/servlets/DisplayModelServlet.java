package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
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
		
		Enumeration<String> names =  req.getAttributeNames();
		System.out.println("checking global attribute names...");
		while(names.hasMoreElements()) {
			System.out.println("Attribute names has: "+names.nextElement());
		}
		//checking to see if modelId was passedcorrectly from another servlett
		if(req.getAttribute("modelId")!= null) {
			id = (Integer)req.getAttribute("modelId");
			System.out.println("Attribute modelId found! id to it");
		}
		else {
			System.out.println("Attribute modelId is null");
		}
		
		if(req.getParameter("modelID")!=null) {
			id = Integer.parseInt(req.getParameter("modelID"));
			System.out.println("modelID != null");
		}
		else if(req.getParameter("overviewModelID")!=null) {
			id = Integer.parseInt(req.getParameter("overviewModelID"));
			overview = true;
			System.out.println("overviewmodelID != null");
		}
		else if (req.getParameter("engPrincipleModelID")!=null) {
			id = Integer.parseInt(req.getParameter("engPrincipleModelID"));
			engPrinciple = true;
			System.out.println("engPrinciplemodelID != null");
		}
		else if (req.getParameter("procedureModelID")!=null) {
			id = Integer.parseInt(req.getParameter("procedureModelID"));
			procedure = true;
			System.out.println("proceduremodelID != null");
		}
		else if (req.getParameter("applicationModelID")!=null) {
			id = Integer.parseInt(req.getParameter("applicationModelID"));
			app = true;
			System.out.println("applicationmodelID != null");
		}
		else if (req.getParameter("materialsModelID")!=null) {
			id = Integer.parseInt(req.getParameter("materialsModelID"));
			material = true;
			System.out.println("materialsmodelID != null");
		}
		else if (req.getParameter("ratingsModelID")!=null) {
			id = Integer.parseInt(req.getParameter("ratingsModelID"));
			rating = true;
			System.out.println("ratingsmodelID != null");
		}
		
		
		System.out.println("The id received from parameters is : "+id);
	
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
