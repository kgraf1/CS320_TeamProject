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
import java.util.Enumeration;
import controllers.*;

public class ProfileOptionsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	int profileId;
	@Override 
	protected void doGet (HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		System.out.println("\n ProfileOptionsServlet: doGet");
		
		Enumeration<String> names =  req.getAttributeNames();
		System.out.println("checking global attribute names...");
		while(names.hasMoreElements()) {
			System.out.println("Attribute names has: "+names.nextElement());
		}
		
		//profileId = Integer.parseInt(req.getParameter("profileId"));
		//System.out.println("Profile Id recieved from Profile is: "+profileId);
		
		req.getRequestDispatcher("/_view/profileoptions.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		
		System.out.println("\n	ProfileOptionsServlet: doPost");
		ProfileOptionsController controller = new ProfileOptionsController();
		
		profileId = 0;
		
		if(req.getParameter("newusername") != null) {
			System.out.println("Changing Username!");
			controller.changeUsername(profileId, req.getParameter("newusername"));
			
		}	
		if(req.getParameter("newpassword") != null) {
			System.out.println("Changing Password!");
			controller.changePassword(profileId, req.getParameter("newpassword"));
			
		}	
		req.getRequestDispatcher("/_view/profilepage.jsp").forward(req, resp);
	}
}