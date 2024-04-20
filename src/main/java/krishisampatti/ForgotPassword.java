package krishisampatti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//forget password implementation...

@WebServlet("/updatePassword")
public class ForgotPassword extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String cpassword=req.getParameter("cpassword");
		String user=req.getParameter("user");
		KrishisampattiCRUD krishisampatti=new KrishisampattiCRUD();
		
		if(user!=null) {
			if(user.equals("farmer")) {
				if(password.equals(cpassword)) {
					try {
						int result=krishisampatti.forgotPassword(email, password,new Farmer());
						if(result!=0) {
							req.setAttribute("user", user);
							req.getRequestDispatcher("login.jsp").forward(req, resp);;
						}
						else {
							req.setAttribute("user", user);
							req.setAttribute("message","something wrong! try again!");
							req.getRequestDispatcher("forgotPassword.jsp").forward(req, resp);
						}
					} catch (Exception e) {
						e.printStackTrace();
						req.setAttribute("user", user);
						req.setAttribute("message","something wrong! try again!");
						req.getRequestDispatcher("forgotPassword.jsp").forward(req, resp);
					}
				}
				else {
					req.setAttribute("user", user);
					req.setAttribute("message","password not matched!");
					req.getRequestDispatcher("forgotPassword.jsp").forward(req, resp);
				}
			}
			else if(user.equals("buyer")) {
				if(password.equals(cpassword)) {
					try {
						int result=krishisampatti.forgotPassword(email, password,new Buyer());
						if(result!=0) {
							req.setAttribute("user", user);
							req.getRequestDispatcher("login.jsp").forward(req, resp);;
						}
						else {
							req.setAttribute("user", user);
							req.setAttribute("message","something wrong! try again!");
							req.getRequestDispatcher("forgotPassword.jsp").forward(req, resp);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						req.setAttribute("user", user);
						req.setAttribute("message","something wrong! try again!");
						req.getRequestDispatcher("forgotPassword.jsp").forward(req, resp);
					}
				}
				else{
					req.setAttribute("user", user);
					req.setAttribute("message","password not matched!");
					req.getRequestDispatcher("forgotPassword.jsp").forward(req, resp);
				}
			}
		}
		
		
		
		
	}
}
