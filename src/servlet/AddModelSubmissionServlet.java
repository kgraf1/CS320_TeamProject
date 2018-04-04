package servlet;

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
		int modelCreated = -1;
		boolean materialsCreated = false;
		boolean keywordsCreated = false;
		boolean applicationCreated = false;
		Category category = null;
		
		// decode POSTed form parameters and dispatch to controller
		try {
			String name = req.getParameter("name");
			category = Category.valueOf(req.getParameter("category"));
			String description = req.getParameter("description");
			String thumbnail = req.getParameter("thumbnail");
			String engPrinciple = req.getParameter("engPrinciple");
			String citation = req.getParameter("citation");
			String procedure = req.getParameter("procedure");
			
			//The lists will contain materialName, quantity, cost, buildTime, and description in that order
			
			List<String> material1 = new ArrayList<String> ();
			material1.add(req.getParameter("material1"));
			material1.add(req.getParameter("quantity1"));
			material1.add(req.getParameter("cost1"));
			material1.add(req.getParameter("buildTime1"));
			material1.add(req.getParameter("description1"));
			
			List<String> material2 = new ArrayList<String> ();
			material2.add(req.getParameter("material2"));
			material2.add(req.getParameter("quantity2"));
			material2.add(req.getParameter("cost2"));
			material2.add(req.getParameter("buildTime2"));
			material2.add(req.getParameter("description2"));
			
			List<String> material3 = new ArrayList<String> ();
			material3.add(req.getParameter("material3"));
			material3.add(req.getParameter("quantity3"));
			material3.add(req.getParameter("cost3"));
			material3.add(req.getParameter("buildTime3"));
			material3.add(req.getParameter("description3"));
			
			List<String> material4 = new ArrayList<String> ();
			material4.add(req.getParameter("material4"));
			material4.add(req.getParameter("quantity4"));
			material4.add(req.getParameter("cost4"));
			material4.add(req.getParameter("buildTime4"));
			material4.add(req.getParameter("description4"));
			
			List<String> material5 = new ArrayList<String> ();
			material5.add(req.getParameter("material5"));
			material5.add(req.getParameter("quantity5"));
			material5.add(req.getParameter("cost5"));
			material5.add(req.getParameter("buildTime5"));
			material5.add(req.getParameter("description5"));
			
			List<String> material6 = new ArrayList<String> ();
			material6.add(req.getParameter("material6"));
			material6.add(req.getParameter("quantity6"));
			material6.add(req.getParameter("cost6"));
			material6.add(req.getParameter("buildTime6"));
			material6.add(req.getParameter("description6"));
			
			List<String> material7 = new ArrayList<String> ();
			material7.add(req.getParameter("material7"));
			material7.add(req.getParameter("quantity7"));
			material7.add(req.getParameter("cost7"));
			material7.add(req.getParameter("buildTime7"));
			material7.add(req.getParameter("description7"));

			List<String> material8 = new ArrayList<String> ();
			material8.add(req.getParameter("material8"));
			material8.add(req.getParameter("quantity8"));
			material8.add(req.getParameter("cost8"));
			material8.add(req.getParameter("buildTime8"));
			material8.add(req.getParameter("description8"));
			
			List<String> material9 = new ArrayList<String> ();
			material9.add(req.getParameter("material9"));
			material9.add(req.getParameter("quantity9"));
			material9.add(req.getParameter("cost9"));
			material9.add(req.getParameter("buildTime9"));
			material9.add(req.getParameter("description9"));
			
			List<String> material10 = new ArrayList<String> ();
			material10.add(req.getParameter("material10"));
			material10.add(req.getParameter("quantity10"));
			material10.add(req.getParameter("cost10"));
			material10.add(req.getParameter("buildTime10"));
			material10.add(req.getParameter("description10"));
		
			List<List<String>> materials = new ArrayList<> ();
			materials.add(material1);
			materials.add(material2);
			materials.add(material3);
			materials.add(material4);
			materials.add(material5);
			materials.add(material6);
			materials.add(material7);
			materials.add(material8);
			materials.add(material9);
			materials.add(material10);
			
			//get keywords
			List<String> keywords = new ArrayList<> ();
			keywords.add(req.getParameter("keyword1"));
			keywords.add(req.getParameter("keyword2"));
			keywords.add(req.getParameter("keyword3"));
			keywords.add(req.getParameter("keyword4"));
			keywords.add(req.getParameter("keyword5"));
			
			//get Application
			String beforeClass = req.getParameter("beforeClass");
			String beforeImage = req.getParameter("beforeImage");
			String duringClass = req.getParameter("duringImage");
			String duringImage = req.getParameter("duringImage");
			
			// check to make sure the user input a name and description
			if (name == null || description == null) {
				errorMessage = "A model needs at least a name and description";
			}
			// otherwise, create the model by calling the controller
			else {
				AddModelSubmissionController modelController = new AddModelSubmissionController();
				AddMaterialsController materialsController = new AddMaterialsController();
				AddKeywordsController keywordsController = new AddKeywordsController();
				AddApplicationController applicationController = new AddApplicationController();
				
				modelCreated = modelController.create(name, description, thumbnail, engPrinciple, citation,
											category, procedure);
				if(modelCreated > 0) {
					materialsCreated = materialsController.create(modelCreated, materials);
					keywordsCreated = keywordsController.create(modelCreated, keywords);
					applicationCreated = applicationController.create(modelCreated, beforeClass, beforeImage, duringClass, duringImage);
				}
				else {
					errorMessage = "The model failed to create";
				}
			}
		} catch (Exception e) {
			errorMessage = "Invalid entry";
		}
		
		// Add parameters as request attributes
		req.setAttribute("name", req.getParameter("name"));
		req.setAttribute("category", req.getParameter("category"));
		req.setAttribute("description", req.getParameter("description"));
		req.setAttribute("engPrinciple", req.getParameter("engPrinciple"));
		
		//Add parameters as request attributes for materials
		req.setAttribute("material1", req.getParameter("material1"));
		req.setAttribute("quantity1", req.getParameter("quantity1"));
		req.setAttribute("cost1", req.getParameter("cost1"));
		req.setAttribute("buildTime1", req.getParameter("buildTime1"));
		req.setAttribute("description1", req.getParameter("description1"));
		
		req.setAttribute("material2", req.getParameter("material2"));
		req.setAttribute("quantity2", req.getParameter("quantity2"));
		req.setAttribute("cost2", req.getParameter("cost2"));
		req.setAttribute("buildTime2", req.getParameter("buildTime2"));
		req.setAttribute("description2", req.getParameter("description2"));
		
		req.setAttribute("material3", req.getParameter("material3"));
		req.setAttribute("quantity3", req.getParameter("quantity3"));
		req.setAttribute("cost3", req.getParameter("cost3"));
		req.setAttribute("buildTime3", req.getParameter("buildTime3"));
		req.setAttribute("description3", req.getParameter("description3"));
		
		req.setAttribute("material4", req.getParameter("material4"));
		req.setAttribute("quantity4", req.getParameter("quantity4"));
		req.setAttribute("cost4", req.getParameter("cost4"));
		req.setAttribute("buildTime4", req.getParameter("buildTime4"));
		req.setAttribute("description4", req.getParameter("description4"));
		
		req.setAttribute("material5", req.getParameter("material5"));
		req.setAttribute("quantity5", req.getParameter("quantity5"));
		req.setAttribute("cost5", req.getParameter("cost5"));
		req.setAttribute("buildTime5", req.getParameter("buildTime5"));
		req.setAttribute("description5", req.getParameter("description5"));
		
		req.setAttribute("material6", req.getParameter("material6"));
		req.setAttribute("quantity6", req.getParameter("quantity6"));
		req.setAttribute("cost6", req.getParameter("cost6"));
		req.setAttribute("buildTime6", req.getParameter("buildTime6"));
		req.setAttribute("description6", req.getParameter("description6"));
		
		req.setAttribute("material7", req.getParameter("material7"));
		req.setAttribute("quantity7", req.getParameter("quantity7"));
		req.setAttribute("cost7", req.getParameter("cost7"));
		req.setAttribute("buildTime7", req.getParameter("buildTime7"));
		req.setAttribute("description7", req.getParameter("description7"));
		
		req.setAttribute("material8", req.getParameter("material8"));
		req.setAttribute("quantity8", req.getParameter("quantity8"));
		req.setAttribute("cost8", req.getParameter("cost8"));
		req.setAttribute("buildTime8", req.getParameter("buildTime8"));
		req.setAttribute("description8", req.getParameter("description8"));
		
		req.setAttribute("material9", req.getParameter("material9"));
		req.setAttribute("quantity9", req.getParameter("quantity9"));
		req.setAttribute("cost9", req.getParameter("cost9"));
		req.setAttribute("buildTime9", req.getParameter("buildTime9"));
		req.setAttribute("description9", req.getParameter("description9"));
		
		req.setAttribute("material10", req.getParameter("material10"));
		req.setAttribute("quantity10", req.getParameter("quantity10"));
		req.setAttribute("cost10", req.getParameter("cost10"));
		req.setAttribute("buildTime10", req.getParameter("buildTime10"));
		req.setAttribute("description10", req.getParameter("description10"));
		
		//add parameters as request attributes for keywords
		req.setAttribute("keyword1", req.getParameter("keyword1"));
		req.setAttribute("keyword2", req.getParameter("keyword2"));
		req.setAttribute("keyword3", req.getParameter("keyword3"));
		req.setAttribute("keyword4", req.getParameter("keyword4"));
		req.setAttribute("keyword5", req.getParameter("keyword5"));
		
		//add parameters as request attributes for application
		req.setAttribute("beforeClass", req.getParameter("beforeClass"));
		req.setAttribute("beforeImage", req.getParameter("beforeImage"));
		req.setAttribute("duringClass", req.getParameter("duringClass"));
		req.setAttribute("duringImage", req.getParameter("duringImage"));
		
		req.setAttribute("errorMessage", errorMessage);
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/modelSubmission.jsp").forward(req, resp);
	}
}
