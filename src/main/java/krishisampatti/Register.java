package krishisampatti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Registration implementation...

@WebServlet("/register")
public class Register extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user=req.getParameter("user");
		
		if(user!=null) {
			req.setAttribute("user", user);
			req.getRequestDispatcher("register.jsp").forward(req, resp);;
		}
	}
}
