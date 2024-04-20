package krishisampatti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prod")
public class AddProduct extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("user");
		String email=req.getParameter("email");
		
		if(user!=null&&email!=null) {
			req.setAttribute("user", user);
			req.setAttribute("email", email);
			req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
		}
	}
}
