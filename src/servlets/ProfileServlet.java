package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Profile;
import model.PhysicalModel;
import controllers.ProfileController;
import java.util.List;
import java.util.ArrayList;

public class ProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override 
	protected void doGet (HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		System.out.println("\n ProfileServlet: doGet");
		
		req.getRequestDispatcher("/_view/profile.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		
		System.out.println("\n	ProfileServlet: doPost");
		
		String profileId = null;
		List<PhysicalModel> models = new ArrayList<> ();
		String errorMessage = null;
		
		ProfileController controller = new ProfileController();
		
		profileId = req.getParameter("profileId");
		
		models = controller.getModels(Integer.parseInt(profileId));
		Profile profile = controller.getProfile(Integer.parseInt(profileId));
		
		req.setAttribute("models", models);
		req.setAttribute("profile", profile);
		req.setAttribute("errorMessage", errorMessage);
		
		//Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/profile.jsp").forward(req, resp);	
	}
}
