package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SearchServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	@Override 
	protected void doGet (HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		System.out.println("\n ModelsByCategoryServlet: doGet");
		
		req.getRequestDispatcher("results.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		
		if(req.getParameter("getKeyword")!=null) {
			req.getRequestDispatcher(req.getContextPath() + "/modelsByKeyword").forward(req, resp);
		}
		else if(req.getParameter("getTitle")!=null) {
			req.getRequestDispatcher(req.getContextPath() + "/modelsByTitle").forward(req, resp);
		}
		else if(req.getParameter("getMaterial")!=null) {
			req.getRequestDispatcher(req.getContextPath() + "/modelsByMaterial").forward(req, resp);
		}
		else if(req.getParameter("getProfile")!=null) {
			req.getRequestDispatcher(req.getContextPath() + "/modelsByProfileName").forward(req, resp);
		}
		else {
			req.getRequestDispatcher(req.getContextPath() + "/modelsByKeyword").forward(req, resp);
		}
		
	}
}
