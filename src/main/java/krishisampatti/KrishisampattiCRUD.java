package krishisampatti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KrishisampattiCRUD  {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/agrodb", "root", "root");
	}

	public int registerFarmer(Farmer farmer) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FARMER VALUES(?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, farmer.getId());
		preparedStatement.setString(2, farmer.getFirstName());
		preparedStatement.setString(3, farmer.getLastName());
		preparedStatement.setString(4, farmer.getEmail());
		preparedStatement.setLong(5, farmer.getPhone());
		preparedStatement.setString(6, farmer.getAddress());
		preparedStatement.setString(7, farmer.getPassword());

		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}

	public int registerBuyer(Buyer buyer) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO BUYER VALUES(?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, buyer.getId());
		preparedStatement.setString(2, buyer.getFirstName());
		preparedStatement.setString(3, buyer.getLastName());
		preparedStatement.setString(4, buyer.getEmail());
		preparedStatement.setLong(5, buyer.getPhone());
		preparedStatement.setString(6, buyer.getAddress());
		preparedStatement.setString(7, buyer.getPassword());

		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}

	public int generateIdOfFarmer() throws ClassNotFoundException, SQLException {
		String sql = "SELECT id FROM FARMER";
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		int id = 1;
		int max = 0;
		while (resultSet.next()) {
			if (resultSet.getInt("id") > max) {
				id = resultSet.getInt("id") + 1;
			}
		}
		connection.close();
		return id;
	}

	public int generateIdOfBuyer() throws ClassNotFoundException, SQLException {
		String sql = "SELECT id FROM BUYER";
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		int id = 1;
		int max = 0;
		while (resultSet.next()) {
			if (resultSet.getInt("id") > max) {
				id = resultSet.getInt("id") + 1;
			}
		}
		connection.close();
		return id;
	}

	public String farmerLogin(String email) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select password from farmer where email=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		String dbPassword = null;
		while (resultSet.next()) {
			dbPassword = resultSet.getString("password");
		}
		connection.close();
		return dbPassword;
	}

	public String buyerLogin(String email) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select password from buyer where email=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		String dbPassword = null;
		while (resultSet.next()) {
			dbPassword = resultSet.getString("password");
		}
		connection.close();
		return dbPassword;
	}

	public int forgotPassword(String email, String newPassword, Object o) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		int result = 0;
		if ((Farmer) o instanceof Farmer) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE FARMER SET PASSWORD=? WHERE EMAIL=?");
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, email);
			result = preparedStatement.executeUpdate();
		} else if ((Buyer) o instanceof Buyer) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE BUYER SET PASSWORD=? WHERE EMAIL=?");
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, email);
			result = preparedStatement.executeUpdate();
		}
		connection.close();
		return result;
	}

	public int addProduct(Product product) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO Product(id,pname,quantity,price,description) VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2, product.getProductName());
		preparedStatement.setDouble(3, product.getQuantity());
		preparedStatement.setDouble(4, product.getPrice());
		preparedStatement.setString(5, product.getDescription());

		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}

	public int generateProductId() throws ClassNotFoundException, SQLException {
		String sql = "SELECT id FROM product";
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		int id = 1;
		int max = 0;
		while (resultSet.next()) {
			if (resultSet.getInt("id") > max) {
				id = resultSet.getInt("id") + 1;
			}
		}
		connection.close();
		return id;
	}

	public List<Product> getAllProduct() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
		ResultSet resultSet = preparedStatement.executeQuery();
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		while (resultSet.next()) {
			product = new Product();
			product.setId(resultSet.getInt("id"));
			product.setProductName(resultSet.getString("pname"));
			product.setQuantity(resultSet.getDouble("quantity"));
			product.setPrice(resultSet.getDouble("price"));
			product.setDescription(resultSet.getString("description"));
			list.add(product);
		}
		connection.close();
		return list;
	}
}
