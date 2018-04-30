package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persist.FakeDatabase;

import model.Profile;
import controllers.LoginController;

/**
 * Servlet implementation class loginServlet
 * 
 * All code in this class is taken from Professor Hake's LibraryExample
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Profile profile;
	private LoginController controller;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("\nLoginServlet: doGet");

		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("\nLoginServlet: doPost");

		String submitType = req.getParameter("submit");
		controller = new LoginController(profile);
		
		String errorMessage = null;
		boolean validLogin = false;
		Profile profile = null;

		if(submitType.equals("Register")) {
			System.out.println("Registering");
			profile = new Profile ();
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String password  = null;
			if(req.getParameter("password1").equals(req.getParameter("password2"))) {
				password = req.getParameter("password1");
				System.out.println("Heading to controller");
				controller.Register(firstName, lastName, username, email, password);
			}
			if((controller.checkUserName(username)==true) && (controller.checkPassword(password)==true)){
				validLogin = true;
				errorMessage = null;
				req.getSession().setAttribute("username", username);
				resp.sendRedirect(req.getContextPath() + "/_view/homepage.jsp");
			}
			else {
				errorMessage="Invalid Login, please try again";
				req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
			}
		}
		else {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			if((controller.checkUserName(username)==true) && (controller.checkPassword(password)==true)){
				validLogin = true;
				errorMessage = null;
				req.getSession().setAttribute("username", username);
				resp.sendRedirect(req.getContextPath() + "/homepage");
			}
			else {
				errorMessage="Invalid Login, please try again";
				req.getRequestDispatcher("/_view/login.jsp").forward(req,resp);
			}
		}
		
	}
}
