package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;

import controllers.AddApplicationController;
import controllers.AddKeywordsController;
import controllers.AddMaterialsController;
import controllers.AddModelSubmissionController;
import controllers.RatingsByModelIdController;
import model.Category;
import persist.DatabaseProvider;
import persist.FakeDatabase;

public class AddRatingSubmissionServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("AddRatingSubmission Servlet: doGet");	
		int id = Integer.parseInt(req.getParameter("modelID"));
		req.setAttribute("modelId",id);
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/ratingSubmission.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("AddRatingSubmission Servlet: doPost");
		//req.setAttribute("newrating", req.getParameter("newrating"));
		
		
		int id = Integer.parseInt(req.getParameter("modelId"));
		int newRating = Integer.parseInt((String)req.getAttribute("newrating"));
		String newComment =(String)req.getAttribute("newcomment");
		
		RatingsByModelIdController controller = new RatingsByModelIdController();
		if(id<=-1) {
			System.out.println("Model id was not imported properly, setting to 1");
			id = 1;
		}
		newComment ="test";
		newRating = 4;
		
		boolean success = controller.addRatingByModelId(id, newRating, newComment);
		if(success){
			System.out.println("Servlett: Adding rating for model Id# "+id+" was successfull");
		}
		else {
			System.out.println("Adding the new rating for model Id #"+id+" was not successfull");
		}
	
		req.getRequestDispatcher("./_view/successRating.jsp").forward(req, resp);
	}

}
