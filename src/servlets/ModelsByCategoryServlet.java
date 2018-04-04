package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PhysicalModel;
import controllers.ModelsByCategoryController;

public class ModelsByCategoryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private ModelsByCategoryController controller = null;
	
	@Override 
	protected void doGet (HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		System.out.println("\n ModelsByCategoryServlet: doGet");
		
		req.getRequestDispatcher("/WebContent/ModelsByCategory.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		System.out.println("\n ModelsByCategoryServlet: doPost");
		
		ArrayList<PhysicalModel> models = null;
		PhysicalModel model = null;
		String category = null;
		String errorMessage = null;
		
		//decode from parameters and dispatch to controller
		category = req.getParameter("category");
		
		//get list of models returned from query
		models = controller.getModelByCategory(category);
		
		//any models found?
		if(models == null) {
			errorMessage = "No Models found by this category";
		}
		else {
			model = models.get(0);
		}
		
		//add parameters as request attributes
		req.setAttribute("category", category);
		
		//Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("model", model);
		req.setAttribute("models", models);
	}
}
