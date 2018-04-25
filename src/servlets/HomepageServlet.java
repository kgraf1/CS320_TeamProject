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
private IDatabase db = null;
	final int MAX_MODELS = 3;
	@Override 
	protected void doGet (HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		System.out.println("\n HomepageServlet: doGet");
		
		List<PhysicalModel> models = new ArrayList<> ();
		List<PhysicalModel> results = new ArrayList<> ();
		String errorMessage = null;
		RatingsByModelIdController rcontroller = new RatingsByModelIdController();
		models = rcontroller.getAllPhysicalModels();
		PhysicalModel model = null;
		
		for(int i = 0; i<models.size();i++) {
			/*check for models that have an average rating above a 2.5
			 * if so add to results
			 * */
			 
			if(rcontroller.getAverageByModelId(models.get(i).getId()) >= 2.5) {
				results.add(models.get(i));
			}
		}
		
		/* Now we check if the number of results is too high
		 * If it is we trim them down. 
		 * Increment the cut off untill we are down to only 3 models
		 */
		models = results;
		double cutoff = 2.5;
		while(results.size()>MAX_MODELS) {
			cutoff +=.25;
			for(int i =0;i<results.size();i++) {
				if(rcontroller.getAverageByModelId(models.get(i).getId()) < cutoff) {
					results.remove(i);
					i--;
				}
			}
			
		}
		//check if results has something. If not just use models
		if(results == null) {
			
		}
		else {
			models = results;
		}
		
		
		if(results == null) {
			errorMessage = "No Models found for some reason";	
		}
		else {
			model = models.get(0);
		}
		req.setAttribute("result", models.size());
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("model", model);
		req.setAttribute("models", models);
		
		req.getRequestDispatcher("/_view/homepage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		
		System.out.println("\n	SearchServlet: doPost");
		
		req.getRequestDispatcher("/_view/homepage.jsp").forward(req, resp);
	}
}
