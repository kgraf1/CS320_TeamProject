package persist;

public class DatabaseProvider {
	//The following code is taken from Professor Hake's LibraryExample
	private static IDatabase theInstance;
	
	public static void setInstance(IDatabase db) {
		theInstance = db;
	}
	
	public static IDatabase getInstance() {
		if (theInstance == null) {
			throw new IllegalStateException("IDatabase instance has not been set!");
		}
		return theInstance;
	}
}
