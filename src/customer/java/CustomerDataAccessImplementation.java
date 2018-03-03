package customer.java;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Provider.java.ConnectionProvider;

public class CustomerDataAccessImplementation implements CustomerDataAccessObject {
	static Connection con;
	static PreparedStatement ps;

	@Override
	public int insertCustomer(Customer c) {
int status=0;
		
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("Insert into customer value(?,?,?,?)");
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getName());
			ps.setString(4, c.getEmail());
			
			
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}

	@Override
	public Customer getCustomer(String username, String password) {
	Customer c=new Customer();
		
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("select * from customer where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				c.setUsername(rs.getString(1));
				c.setPassword(rs.getString(2));
				c.setName(rs.getString(3));
				c.setEmail(rs.getString(4));
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return c;
	}

}
