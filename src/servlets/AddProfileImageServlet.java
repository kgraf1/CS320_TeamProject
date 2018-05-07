package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;


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
		
		profileId = Integer.parseInt(req.getParameter("profileId"));
		System.out.println(profileId);

		System.out.println("AddProfileImage Servlet: doGet");
		req.getRequestDispatcher("/_view/profileImage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("AddProfileImage Servlet: doPost");
	
		String profileImage =req.getParameter("profileImage");
			
		AddProfileImageController controller = new AddProfileImageController();
		
				
		boolean success = controller.create(profileId, profileImage);
		if(success){
			System.out.println("AddProfileImageServlet: Adding image for profile Id# "+profileId+" was successful");
		}
		else {
			System.out.println("Adding the new image for profile Id #"+profileId+" was not successful");
		}
		req.setAttribute("profileId", profileId);
		req.getRequestDispatcher("profilePage").forward(req, resp);
		
	}

}
