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
import persist.IDatabase;

public class redirectToAddImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDatabase db = null;
	
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		System.out.println("\n RedirectServlet: doGet");
		
		
		
		
		req.getRequestDispatcher("/_view/profileImage.jsp");
	}
	
	protected void doPost (HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
		System.out.println("\n RedirectServlet: doPost");
		
		int id = Integer.parseInt(req.getParameter("profileId"));
		
		req.setAttribute("profileId", id);
		
		req.getRequestDispatcher("/_view/profileImage.jsp").forward(req, resp);
	}
}
