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
	private int savedId;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("AddRatingSubmission Servlet: doGet");	
		int id = Integer.parseInt(req.getParameter("modelID"));
		savedId = id;
		req.setAttribute("modelID",id);
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/ratingSubmission.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("AddRatingSubmission Servlet: doPost");
		//req.setAttribute("newrating", req.getParameter("newrating"));
		
		
		int id = savedId;
		
		int newRating = Integer.parseInt((String)req.getParameter("newrate"));
		String newComment =(String)req.getParameter("newcomment");
		
		
		
		RatingsByModelIdController controller = new RatingsByModelIdController();
		//if(id<=-1 ) {
		//	System.out.println("Model id was not imported properly, setting to 1");
		//	id = 1;
		//}
				
		boolean success = controller.addRatingByModelId(id, newRating, newComment);
		if(success){
			System.out.println("AddRatingSubmissionServlett: Adding rating for model Id# "+id+" was successfull");
		}
		else {
			System.out.println("Adding the new rating for model Id #"+id+" was not successfull");
		}
		req.setAttribute("modelId", id);
		req.setAttribute("modelID", id);
		req.setAttribute("overviewModelID", id);
		//req.getRequestDispatcher("/_view/model.jsp").forward(req, resp);
		req.getRequestDispatcher("DisplayModel").forward(req, resp);
		
	}

}
