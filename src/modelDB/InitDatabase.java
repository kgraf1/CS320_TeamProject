package modelDB;

import java.util.Scanner;

import persist.DatabaseProvider;
//import persist.DerbyDatabase;
import persist.FakeDatabase;

public class InitDatabase {
	public static void init(Scanner keyboard) {
		System.out.print("Which database (0=fake, 1=SQL): ");
		int which = Integer.parseInt(keyboard.nextLine());
		if (which == 0) {
			DatabaseProvider.setInstance(new FakeDatabase());
		} else if (which == 1) {
			System.out.print("This has not been implemented yet");
			//DatabaseProvider.setInstance(new DerbyDatabase());
		} else {
			throw new IllegalArgumentException("Invalid choice: " + which);
		}
	}
}
