package krishisampatti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//for login implementation

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String user=req.getParameter("user");
		
		KrishisampattiCRUD krishisampatti=new KrishisampattiCRUD();
		if(user!=null) {
			if(user.equals("farmer")) {
				try {
					String dbPassword=krishisampatti.farmerLogin(email);
					if(dbPassword!=null) {
						if(dbPassword.equals(password)) {
							req.setAttribute("user",user);
							req.setAttribute("email",email);
							req.setAttribute("products", krishisampatti.getAllProduct());
							req.getRequestDispatcher("success.jsp").forward(req, resp);
						}
						else {
							req.setAttribute("user",user);
							req.setAttribute("message","invalid password !");
							req.getRequestDispatcher("login.jsp").forward(req, resp);
						}
					}
					else {
						req.setAttribute("user",user);
						req.setAttribute("message","user not exist register here !");
						req.getRequestDispatcher("register.jsp").forward(req, resp);
					}
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
			else if(user.equals("buyer")) {
				try {
					String dbPassword=krishisampatti.buyerLogin(email);
					if(dbPassword!=null) {
						if(dbPassword.equals(password)) {
							req.setAttribute("user",user);
							req.setAttribute("email",email);
							req.getRequestDispatcher("success.jsp").forward(req, resp);;
						}
						else {
							req.setAttribute("user",user);
							req.setAttribute("message","invalid password !");
							req.getRequestDispatcher("login.jsp").forward(req, resp);
						}
					}
					else {
						req.setAttribute("user",user);
						req.setAttribute("message","user not exist register here !");
						req.getRequestDispatcher("register.jsp").forward(req, resp);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
