package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PhysicalModel;
import controllers.ModelsByMaterialController;

public class ModelsByMaterialServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private ModelsByMaterialController controller = new ModelsByMaterialController();
	
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException{
		System.out.println("\n ModelsByMaterialServlet: doGet");
		
		req.getRequestDispatcher("/_view/search.jsp").forward(req,  resp);
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		System.out.println("\n ModelsByMaterialServlet: doPost");
		
		ArrayList<PhysicalModel> models = null;
		String errorMessage = null;
		String searchInput = null;
		PhysicalModel model = null;
		
		controller = new ModelsByMaterialController();
		
		//decode from parameters and dispatch to controller
		searchInput = req.getParameter("searchInput");
		
		//get list of models returned from query
		models = controller.getModelByMaterialName(searchInput);
		
		//any models found?
		if(models == null) {
			errorMessage = "No Models found with this material";
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
		req.getRequestDispatcher("/_view/ModelsByMaterial.jsp").forward(req, resp);
	}
}
