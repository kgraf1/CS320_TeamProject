package modelDB;

import java.util.List;
import java.util.Scanner;

import model.PhysicalModel;
import persist.DatabaseProvider;
//import persist.DerbyDatabase;
import persist.IDatabase;

public class ModelByCategory {
	public static void main(String [] args) throws Exception{
		Scanner keyboard = new Scanner(System.in);
		
		//Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		System.out.print("Enter a string: ");
		String categories = keyboard.next();
		String [] split = categories.split(" ");
		
		
		for (int i=0; i<split.length; i++) {
			String category= split[i];
			//get the DB instance and execute transaction
			IDatabase db = DatabaseProvider.getInstance();
			List<PhysicalModel> modelList = db.findModelsByCategory(category);
			

			//check if anything was returned and output the list
			if(modelList.isEmpty()) {
				System.out.println("No Models found with this category");
			}
			else {
				for(PhysicalModel model: modelList) {
					System.out.println(model.getTitle() + " " + model.getDecription());
				}
			}	
			
			
		}
	}
}
