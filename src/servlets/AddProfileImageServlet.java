package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;

import controllers.AddProfileImageController;
import model.Category;
import persist.DatabaseProvider;
import persist.FakeDatabase;

public class AddProfileImageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int profileId;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Enumeration<String> names =  req.getAttributeNames();
		System.out.println("checking global attribute names...");
		while(names.hasMoreElements()) {
			System.out.println("Attribute names has: "+names.nextElement());
		}
		
		profileId = Integer.parseInt(req.getParameter("profileId"));
		System.out.println(profileId);

		System.out.println("AddProfileImage Servlet: doGet");
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("AddProfileImage Servlet: doPost");
		
		//Enumeration<String> names =  req.getAttributeNames();
		//System.out.println("checking global attribute names...");
		//while(names.hasMoreElements()) {
			//System.out.println("Attribute names has: "+names.nextElement());
		//}
		
		//profileId = Integer.parseInt(req.getParameter("profileId"));
		//System.out.println(profileId);
		
		//int id = (int)req.getAttribute("profileId");
		
		
		String profileImage =req.getParameter("profileImage");
			
		AddProfileImageController controller = new AddProfileImageController();
		
				
		boolean success = controller.create(profileId, profileImage);
		if(success){
			System.out.println("AddProfileImageServlet: Adding image for profile Id# "+ profileId +" was successful");
		}
		else {
			System.out.println("Adding the new image for profile Id #"+ profileId +" was not successful");
		}
		req.setAttribute("profileId", profileId);
		req.getRequestDispatcher("profilePage").forward(req, resp);
		
	}

}
