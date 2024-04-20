package krishisampatti;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addProduct")
public class ProductCotroller extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pname=req.getParameter("pname");
		double quantity=Double.parseDouble(req.getParameter("quantity"));
		double price=Double.parseDouble(req.getParameter("price"));
		String desc=req.getParameter("desc");
		String user=req.getParameter("user");
		String email=req.getParameter("email");
		
		
		Product product=new Product();
		KrishisampattiCRUD krishisampatti=new KrishisampattiCRUD();
		
		try {
			product.setId(krishisampatti.generateProductId());
			product.setProductName(pname);
			product.setQuantity(quantity);
			product.setPrice(price);
			product.setDescription(desc);
			
			int result=krishisampatti.addProduct(product);
			if(result!=0) {
				req.setAttribute("products", krishisampatti.getAllProduct());
				req.setAttribute("user", user);
				req.setAttribute("email", email);
				req.getRequestDispatcher("success.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("message", "product not get added");
				req.getRequestDispatcher("success.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
