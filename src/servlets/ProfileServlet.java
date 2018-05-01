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
		
		List<PhysicalModel> models = new ArrayList<> ();
		String errorMessage = null;
		
		ProfileController controller = new ProfileController();
		
		String username = (String)req.getSession().getAttribute("username");
		int profileId = controller.getProfileIdByUsername(username);
		
		models = controller.getModels(profileId);
		Profile profile = controller.getProfile(profileId);
		
		req.setAttribute("models", models);
		req.setAttribute("profile", profile);
		req.setAttribute("errorMessage", errorMessage);
		
		System.out.println("Displaying " + models.size() + " models.");
		
		req.getRequestDispatcher("/_view/profilepage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		
		System.out.println("\n	ProfileServlet: doPost");
		
		if(req.getParameter("SubmitModel") != null) {
			resp.sendRedirect(req.getContextPath() + "/addModelSubmission");
		}
		if(req.getParameter("logout") != null) {
			resp.sendRedirect(req.getContextPath() + "/login");
		}	
	}
}
