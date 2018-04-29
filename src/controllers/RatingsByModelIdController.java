package controllers;

import java.util.ArrayList;
import java.util.List;

import model.PhysicalModel;
import model.Rating;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.FakeDatabase;
import persist.IDatabase;

public class RatingsByModelIdController {
	private IDatabase db = null;
	
	public RatingsByModelIdController(){
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
				
		/*
		 * Uncomment below for Fake Database use
		 */
		//db = DatabaseProvider.getInstance();
	}
	public ArrayList<Rating> getRatingsByModelId (int modelId){
		ArrayList<Rating> ratings = null;
		List <Rating> ratingList = db.findRatingsByModelId(modelId);
		
		if(ratingList.isEmpty()) {
			ratings = null;
			System.out.println("Model id# "+modelId+" does not have any ratings");
		}
		else {
			ratings = new ArrayList<Rating>();
			for( Rating rating:ratingList) {
				ratings.add(rating);
			}
			System.out.println("Model id# "+modelId+" has : "+ratingList.size()+" Ratings");
		}
		return ratings;
	}
	public double getAverageByModelId(int modelId) {
		double average = 0;
		List <Rating> ratingList = db.findRatingsByModelId(modelId);
		
		if(ratingList.isEmpty()) {
			average = 0;
			System.out.println("Model id# "+modelId+" does not have any ratings, thus no average");
		}
		else {
			double total =0;
			
			for( Rating rating:ratingList) {
				total += rating.getRate();
			}
			average = total/ratingList.size();
			System.out.println("Model id# "+modelId+" has an average rating of: "+average);
		}
		return average;
	}
	public boolean addRatingByModelId(int modelId, int rate, String comment) {
		System.out.println("Attempting to insert a new Rating for modelId: "+modelId);
		int rateId =db.insertRatingIntoRatingTable(modelId, rate, comment);
		if(rateId !=-1) {
			System.out.println("Rating for model #"+modelId+" added successfully");
			return true;
		}
		else {
			System.out.println("Rating for model #"+modelId+" not added");
			return false;
		}
	}
	public List<PhysicalModel> getAllPhysicalModels(){
		List<PhysicalModel> models = new ArrayList<PhysicalModel>();
		models = db.getAllModels();
		for(int i=0; i<models.size(); i++) {
			System.out.println(models.get(i).getTitle());
			System.out.println(models.get(i).getId());
		}
		return models;
		//return db.getAllModels();
	}
	
}
