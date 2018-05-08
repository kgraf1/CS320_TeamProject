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
	Integer profileId;
	@Override 
	protected void doGet (HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		System.out.println("\n ProfileOptionsServlet: doGet");
		
		
		
		//profileId = Integer.parseInt(req.getParameter("profileId"));
		//System.out.println("Profile Id recieved from Profile is: "+profileId);
		
		req.getRequestDispatcher("/_view/profileoptions.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		
		System.out.println("\n	ProfileOptionsServlet: doPost");
		ProfileOptionsController controller = new ProfileOptionsController();
		
		//this just checks for avaliable global attributes to pull info from
		Enumeration<String> names =  req.getAttributeNames();
		System.out.println("checking global attribute names...");
		while(names.hasMoreElements()) {
			System.out.println("Attribute names has: "+names.nextElement());
		}

		
		String username = (String)req.getSession().getAttribute("username");
	
		String newusername = req.getParameter("newusername");
		String newpassword = req.getParameter("newpassword");
		
		if(!newusername.equals(null) && !newusername.equals("") ) {
			System.out.println("Changing Username!");
			controller.changeUsername(username, newusername);
			
		}	
		if(!newpassword.equals(null) && !newpassword.equals("")) {
			System.out.println("Changing Password!");
			controller.changePassword(username, newpassword);
			
		}	
		resp.sendRedirect(req.getContextPath() + "/profilePage");
	}
}