package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PhysicalModel;
import controllers.ModelsByKeywordController;

public class ModelsByKeywordsServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private ModelsByKeywordController controller= null;
	
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		System.out.println("\n ModelsByKeywordsServlet: doGet");
		
		req.getRequestDispatcher("/WebContent/ModelsByKeywords.jsp");
	}
	
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.print("\n ModelsByKeywordsServlet: doPost");
		
		ArrayList<PhysicalModel> models = null;
		String errorMessage = null;
		String keywords = null;
		PhysicalModel model = null;
		
		controller = new ModelsByKeywordController();
		
		//decode form parameters and dispatch to controller 
		keywords = req.getParameter("keywords");
		
		//get list of models returned from query
		models = controller.getModelByKeywords(keywords);
		
		//any models found?
		if(models == null) {
			errorMessage = "No Models found with those keywords";	
		}
		else {
			model = models.get(0);
		}
		
		//add parameters as request attributes
		req.setAttribute("keywords", keywords);
		
		//add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("model", model);
		req.setAttribute("models", models);
		
		//Forward to view to render the result HTML document
		req.getRequestDispatcher("/WebContent/ModelByKeywords.jsp");
	}
}
