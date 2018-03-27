package persist;

import java.io.IOException;

public class DerbyDatabase {	
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		//DerbyDatabase db = new DerbyDatabase();
		
		//db.createTables();
			
		System.out.println("Loading fake database initial data...");
	
		FakeDatabase fdb = new FakeDatabase();
		
		System.out.println("Success!");
	}
}
