package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PhysicalModel;
import controllers.ModelsByProfileNameController;


public class ModelsByProfileNameServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private ModelsByProfileNameController controller = new ModelsByProfileNameController();
	
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException{
		System.out.println("\n ModelsByProfileNameServlet: doGet");
		
		req.getRequestDispatcher("/_view/search.jsp").forward(req,  resp);
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		System.out.println("\n ModelsByProfileNameServlet: doPost");
		
		ArrayList<PhysicalModel> models = null;
		String errorMessage = null;
		String searchInput = null;
		PhysicalModel model = null;
		
		controller = new ModelsByProfileNameController();
		
		//decode from parameters and dispatch to controller
		searchInput = req.getParameter("searchInput");
		System.out.println("searchInput: " + searchInput);
		
		//get list of models returned from query
		models = controller.getModelByProfileFirstOrLastName(searchInput);
		
		//any models found?
		if(models == null) {
			errorMessage = "No Models found by this profile";
		}
		else {
			model = models.get(0);
		}
		
		//add parameters as request attributes
		req.setAttribute("searchInput", searchInput);
		
		//Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("model", model);
		req.setAttribute("models", models);
		
		//Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/ModelsByProfileName.jsp").forward(req, resp);
	}
}
