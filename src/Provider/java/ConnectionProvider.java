package Provider.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements LoginProvider {
static Connection con=null;
	
	public static Connection getCon() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//com.mysql.jdbc.Driver
			con=DriverManager.getConnection(connUrl, username, password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
