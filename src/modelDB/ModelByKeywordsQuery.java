package modelDB;

import java.util.List;
import java.util.Scanner;

import model.PhysicalModel;
import persist.DatabaseProvider;
//import persist.DerbyDatabase;
import persist.IDatabase;

public class ModelByKeywordsQuery {
	public static void main(String [] args) throws Exception{
		Scanner keyboard = new Scanner(System.in);
		
		//Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		System.out.print("Enter a String:");
		String keywords = keyboard.nextLine();
		String [] split = keywords.split(" ");
		
		
		for(int i=0; i<split.length; i++) {
			//get the DB instance and execute transaction
			String keyword = split[i];
			IDatabase db = DatabaseProvider.getInstance();
			List<PhysicalModel> modelList = db.findModelsByKeyword(keyword);
		

			//check if anything was returned and output the list
			if(modelList.isEmpty()) {
				System.out.println("No Models found with this keyword");
			}
			else {
				for(PhysicalModel model: modelList) {
					System.out.println(model.getTitle() + " | " + model.getDescription());
				}
			}	
		}
	}
}
