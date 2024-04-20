package krishisampatti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class RegisterController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String email=req.getParameter("email");
		long phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		String password=req.getParameter("password");
		String user=req.getParameter("user");
		
		KrishisampattiCRUD krishisampatti=new KrishisampattiCRUD();
		
		if(user!=null) {
			if(user.equals("farmer")) {
				Farmer farmer=new Farmer();
				try {
					farmer.setId(krishisampatti.generateIdOfFarmer());
					farmer.setFirstName(fname);
					farmer.setLastName(lname);
					farmer.setEmail(email);
					farmer.setPhone(phone);
					farmer.setAddress(address);
					farmer.setPassword(password);
					
					int result=krishisampatti.registerFarmer(farmer);
					if(result!=0) {
						req.setAttribute("user", user);
						req.getRequestDispatcher("login.jsp").forward(req, resp);
					}
					
				}catch (Exception e) {
					e.printStackTrace();
					req.setAttribute("message", "User with this email is already exist....");
					req.setAttribute("user", user);
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			}
			else if(user.equals("buyer")) {
				Buyer buyer=new Buyer();
				try {
					buyer.setId(krishisampatti.generateIdOfBuyer());
					buyer.setFirstName(fname);
					buyer.setLastName(lname);
					buyer.setEmail(email);
					buyer.setPhone(phone);
					buyer.setAddress(address);
					buyer.setPassword(password);
					
					int result=krishisampatti.registerBuyer(buyer);
					if(result!=0) {
						req.setAttribute("user", user);
						req.getRequestDispatcher("login.jsp").forward(req, resp);
					}
					else {
						req.setAttribute("user", user);
						req.getRequestDispatcher("register.jsp").forward(req, resp);
					}
					
				}catch (Exception e) {
					e.printStackTrace();
					req.setAttribute("message", "User with this email is already exist....");
					req.setAttribute("user", user);
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			}
		}
	}
}
