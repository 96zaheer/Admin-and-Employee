package test.com;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	private DatabaseConnection() {
	}

	public static Connection getCon() {
		Connection connection = null;
		try {
			Class.forName(DatabaseInfo.driver);
			connection = DriverManager.getConnection(DatabaseInfo.DatabaseUrl, DatabaseInfo.Uname, DatabaseInfo.pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
