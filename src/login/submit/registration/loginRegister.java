package login.submit.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginRegister
 */
@WebServlet("/loginRegister")
public class loginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginRegister() {
     
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CustomerDataAccessObject cd = new CustomerDataAccessImplementation();
		String userName=req.getParameter("username");
		String password=req.getParameter("password1");
		String submitType=req.getParameter("submit");
		Customer c= cd.getCustomer(userName, password);
		
		
		//If the user presses the log in button and the customer and name are found then login continues
		if(submitType.equals("Log In") && c!=null && c.getName()!=null) {
			req.setAttribute("message", c.getName());
			req.getRequestDispatcher("homepage.jsp").forward(req, resp);
		}
		//If the user presses the register button they will continue to registration
		else if(submitType.equals("Register")) {
			c.setName(req.getParameter("name"));
			c.setPassword(password);
			c.setUsername(userName);
			c.setEmail(req.getParameter("email"));
			cd.insertCustomer(c);
			req.setAttribute("successMessage", "Registration complete, please login");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		//If the user had clicked on log in and were not found in the database this message will show
		else {
			req.setAttribute("message", "Data Not Found: click on Register link");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

}
