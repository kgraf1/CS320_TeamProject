package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import controller
import model.PhysicalModel;
import model.Application;
import model.Category;

public class AddModelSubmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("AddModelSubmission Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/addModelSubmission.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("AddModelSubmission Servlet: doPost");
		

		// holds the error message text, if there is any
		String errorMessage = null;

		// the new submission 
		PhysicalModel model = null;
		Category category = null;
		Application application = null;
		
		// decode POSTed form parameters and dispatch to controller
		try {
			String name = req.getParameter("name");
			category = Category.valueOf(req.getParameter("category"));
			String description = req.getParameter("description");
			String engPrinciple = req.getParameter("engPrinciple");
			//get materials
			//get Application
			
			// check to make sure the user input a name and description
			if (name == null || description == null) {
				errorMessage = "A model needs at least a name and description";
			}
			// otherwise, create the model by calling the controller
			else {
				AddModelSubmissionController controller = new AddModelSubmissionController();
				model = controller.create(name, category, description, engPrinciple);
			}
		} catch (Exception e) {
			errorMessage = "Invalid entry";
		}
		
		// Add parameters as request attributes
		req.setAttribute("name", req.getParameter("name"));
		req.setAttribute("category", req.getParameter("category"));
		req.setAttribute("description", req.getParameter("description"));
		req.setAttribute("engPrinciple", req.getParameter("engPrinciple"));
		//materials
		//applicaiton
		
		req.setAttribute("errorMessage", errorMessage);
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/modelSubmission.jsp").forward(req, resp);
	}
}
