package controllers;

import java.util.ArrayList;
import java.util.List;

import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class AddKeywordsController {

	private IDatabase db = null;

	public AddKeywordsController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public boolean create(int modelId, List<String> keywords) {
		
		List<Integer> keywordIds = new ArrayList<Integer> ();
		
		// insert the materials into DB
		for(String word : keywords) {
			if(word != null) {
				keywordIds.add(db.insertKeywordIntoKeywordTable(modelId, word));
			}
		}

		// check if the insertions succeeded
		if (!keywordIds.contains(-1))
		{
			System.out.println("New keyword(s) (IDs: " +  keywordIds.toString() + ") successfully added to Keyword table.");
			
			return true;
		}
		else
		{
			List<Integer> failureIds = new ArrayList<> ();
			
			for(Integer id : keywordIds) {
				if(id < 0) {
					failureIds.add(id);
				}
			}
			
			System.out.println("Failed to insert new keyword(s) (IDs: " + failureIds.toString() + ") into Keyword table.");
			
			return false;
		}
	}
}
