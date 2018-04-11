package controllers;

import java.util.ArrayList;
import java.util.List;

import persist.DatabaseProvider;
import persist.FakeDatabase;
import persist.IDatabase;

public class AddKeywordsController {

	private IDatabase db = null;

	public AddKeywordsController() {
		
		// creating DB instance here
		db = DatabaseProvider.getInstance();		
	}

	public boolean create(int modelId, List<String> keywords) {
		
		List<Integer> keywordIds = new ArrayList<Integer> ();
		
		// insert the materials into DB
		for(int i =0; i<keywords.size();i++) {
			if(keywords.get(i)== null) {
				keywords.remove(i);
				i--;
			}
		}
		
		for(String word : keywords) {
			if(word != null) {
				keywordIds.add(db.insertKeywordIntoKeywordTable(modelId, word));
				System.out.println("Keyword "+word+" has been added");
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
