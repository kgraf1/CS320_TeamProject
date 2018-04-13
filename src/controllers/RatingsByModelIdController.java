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
		// retrieving DB instance here
				db = DatabaseProvider.getInstance();
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
}
