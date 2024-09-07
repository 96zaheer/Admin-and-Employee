package test.com;

import java.sql.*;

//import oracle.jdbc.driver.DBConversion;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

public class AdminDao {

	// Method to validate login (you can use this in LoginServlet.java later)
	public AdminBean loginAdmin(String adminName, String password) {
		AdminBean admin = null;
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = DatabaseConnection.getCon();

			// SQL query to validate admin credentials
			String sql = "SELECT * FROM admin WHERE admin_name = ? AND password = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, adminName);
			ps.setString(2, password);

			// Execute query and fetch results
			ResultSet rs = ps.executeQuery();

			// If a match is found, create an AdminBean object and set the details
			if (rs.next()) {
				admin = new AdminBean();
				admin.setId(rs.getInt(1));
				admin.setAdminName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setFirstName(rs.getString(4));
				admin.setLastName(rs.getString(5));
				admin.setEmail(rs.getString(6));
				admin.setPhone(Long.parseLong(rs.getString(7)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return admin; // Return the AdminBean object if login is successful, otherwise null
	}

	public int registerAdmin(AdminBean ab) {

		int k = 0;
		try {
			Connection con = DatabaseConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into Admin values(?,?,?,?,?,?,?)");
			ps.setInt(1, ab.getId());
			ps.setString(2, ab.getAdminName());
			ps.setString(3, ab.getPassword());
			ps.setString(4, ab.getFirstName());
			ps.setString(5, ab.getLastName());
			ps.setString(6, ab.getEmail());
			ps.setLong(7, ab.getPhone());

			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;
	}
}
