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

		
		
		profileId = (Integer) req.getSession().getAttribute("profileId");
		if(profileId == null) {
			System.out.println("profileId is null. Setting to pre set id of 0");
			profileId = 0;
		}
		String newusername = req.getParameter("newusername");
		String newpassword = req.getParameter("newpassword");
		System.out.println("Profile id the changes are going to is: "+profileId);
		System.out.println("New username is: '"+newusername+"'");
		System.out.println("New password is: '"+newpassword+"'");
		
		if(!newusername.equals(null) && !newusername.equals("") ) {
			System.out.println("Changing Username!");
			controller.changeUsername(profileId, newusername);
			
		}	
		if(!newpassword.equals(null) && !newpassword.equals("")) {
			System.out.println("Changing Password!");
			controller.changePassword(profileId, newpassword);
			
		}	
		req.getRequestDispatcher("/_view/profilepage.jsp").forward(req, resp);
	}
}