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
		System.out.println("\n SearchServlet: doGet");
		
		req.getRequestDispatcher("/_view/search.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
		
		System.out.println("\n	SearchServlet: doPost");
		
		System.out.println(req.getParameter("search"));
		
		if(req.getParameter("search").equals("getKeyword")) {
			
			req.getRequestDispatcher("./ModelsByKeyword").forward(req, resp);
		}
		else if(req.getParameter("search").equals("getTitle")) {
			req.getRequestDispatcher("./ModelsByTitle").forward(req, resp);
		}
		else if(req.getParameter("search").equals("getMaterial")) {
			req.getRequestDispatcher("./ModelsByMaterial").forward(req, resp);
		}
		else if(req.getParameter("search").equals("getProfile")) {
			req.getRequestDispatcher("./ModelsByProfileName").forward(req, resp);
		}
		//else {
			//req.getRequestDispatcher("./ModelsByKeyword").forward(req, resp);
		//}
		
	}
}
