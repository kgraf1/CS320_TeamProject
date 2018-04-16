package persist;

import java.io.IOException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import model.Application;
import model.Category;
import model.Keyword;
import model.Material;
import model.PhysicalModel;
import model.Profile;
import model.Rating;
import model.PhysicalModel;

public class DerbyDatabase implements IDatabase {	
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	// wrapper SQL transaction function that calls actual transaction function (which has retries)
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
		
	// SQL transaction function which retries the transaction MAX_ATTEMPTS times before failing
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
			
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
				
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
				
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
				
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:C:/Users/katek/CS320_TeamProject/database.db;create=true");		
		
		// Set autocommit() to false to allow the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	//retrieves Model information from query result set
	private void loadModel(PhysicalModel model, ResultSet resultSet, int index) throws SQLException {
		model.setId(resultSet.getInt(index++));
		model.setProfileId(resultSet.getInt(index++));
		model.setTitle(resultSet.getString(index++));
		model.setDescription(resultSet.getString(index++));
		model.setThumbnail(resultSet.getString(index++));
		model.setEngPrinciple(resultSet.getString(index++));
		model.setCitation(resultSet.getString(index++));
		model.setCategory(Category.valueOf(resultSet.getString(index++).toUpperCase()));
		model.setProcedure(resultSet.getString(index++));
	}
	
	//retrieves Profile information from query result set
	private void loadProfile(Profile profile, ResultSet resultSet, int index) throws SQLException {
		profile.setId(resultSet.getInt(index++));
		profile.setUsername(resultSet.getString(index++));
		profile.setPassword(resultSet.getString(index++));
		profile.setFirstName(resultSet.getString(index++));
		profile.setLastName(resultSet.getString(index++));
		profile.setEmail(resultSet.getString(index++));
	}
	
	//retrieves Material information from query result set
	private void loadMaterial(Material material, ResultSet resultSet, int index) throws SQLException {
		material.setId(resultSet.getInt(index++));
		material.setModelId(resultSet.getInt(index++));
		material.setQuantity(resultSet.getString(index++));
		material.setName(resultSet.getString(index++));
		material.setDescription(resultSet.getString(index++));
	}
	
	//retrieves Rating information from query result set
	private void loadRating(Rating rating, ResultSet resultSet, int index) throws SQLException {
		rating.setId(resultSet.getInt(index++));
		rating.setModelId(resultSet.getInt(index++));
		rating.setRate(resultSet.getInt(index++));
		rating.setComment(resultSet.getString(index++));
	}
	
	//retrieves Keyword information from query result set
	private void loadKeyword(Keyword keyword, ResultSet resultSet, int index) throws SQLException {
		keyword.setId(resultSet.getInt(index++));
		keyword.setModelId(resultSet.getInt(index++));
		keyword.setWord(resultSet.getString(index++));
	}
	
	//retrieves Application information from query result set
	private void loadApplication(Application application, ResultSet resultSet, int index) throws SQLException {
		application.setId(resultSet.getInt(index++));
		application.setModelId(resultSet.getInt(index++));
		application.setBeforeClass(resultSet.getString(index++));
		application.setBeforeImage(resultSet.getString(index++));
		application.setDuringClass(resultSet.getString(index++));
		application.setDuringImage(resultSet.getString(index++));
		
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		
		db.createTables();
			
		System.out.println("Loading database initial data...");
	
		db.loadInitialData();
		
		System.out.println("Success!");
	}
	

//  creates all of the tables
	//TODO: Need to change this class to create all of the tables for our project
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;				
			
				try {
					stmt1 = conn.prepareStatement(
						"create table authors (" +
						"	author_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +									
						"	lastname varchar(40)," +
						"	firstname varchar(40)" +
						")"
					);	
					stmt1.executeUpdate();
					
					System.out.println("Authors table created");
					
					stmt2 = conn.prepareStatement(
							"create table books (" +
							"	book_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
//							"	author_id integer constraint author_id references authors, " +  	// this is now in the BookAuthors table
							"	title varchar(70)," +
							"	isbn varchar(15)," +
							"   published integer" +
							")"
					);
					stmt2.executeUpdate();
					
					System.out.println("Books table created");					
					
					stmt3 = conn.prepareStatement(
							"create table bookAuthors (" +
							"	book_id   integer constraint book_id references books, " +
							"	author_id integer constraint author_id references authors " +
							")"
					);
					stmt3.executeUpdate();
					
					System.out.println("BookAuthors table created");					
										
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	// loads data retrieved from CSV files into DB tables in batch mode
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<PhysicalModel> modelList;
				List<Material> materialList;
				List<Application> applicationList;
				List<Rating> ratingList;
				List<Keyword> keywordList;
				List<Profile> profileList;
				
				try {
					modelList = InitialData.getPhysicalModels();
					materialList = InitialData.getMaterials();
					applicationList = InitialData.getApplications();
					ratingList = InitialData.getRatings();
					keywordList = InitialData.getKeywords();
					profileList = InitialData.getProfiles();				
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				
				PreparedStatement insertModel = null;
				PreparedStatement insertMaterial = null;
				PreparedStatement insertApplication = null;
				PreparedStatement insertRating = null;
				PreparedStatement insertKeyword = null;
				PreparedStatement insertProfile = null;
			

				try {
					// must completely populate Profile table before the models table
					insertProfile = conn.prepareStatement("insert into profiles (username, password, firstName, lastName, email) values (?, ?, ?, ?, ?)");
					for (Profile profile : profileList) {
						insertProfile.setString(1, profile.getUsername());
						insertProfile.setString(2, profile.getPassword());
						insertProfile.setString(3, profile.getFirstName());
						insertProfile.setString(4, profile.getLastName());
						insertProfile.setString(5, profile.getEmail());
						insertProfile.addBatch();
					}
		
					insertProfile.executeBatch();
					
					System.out.println("Profiles table populated");
					
					// must completely populate PhysicalModel table
					insertModel = conn.prepareStatement("insert into models (profileId, title, description, thumbnail, engPrinciple, citation,"
							+ "category, procedure) values (?, ?, ?, ?, ?, ?, ?, ?)");
					for (PhysicalModel model : modelList) {
						insertModel.setInt(1, model.getProfileId());
						insertModel.setString(2, model.getTitle());
						insertModel.setString(3, model.getDescription());
						insertModel.setString(4, model.getThumbnail());
						insertModel.setString(5, model.getEngPrinciple());
						insertModel.setString(6, model.getCitation());
						insertModel.setString(7, model.getCategory().toString());
						insertModel.setString(8, model.getProcedure());
						insertModel.addBatch();
					}		
					
					insertModel.executeBatch();
					
					System.out.println("Models table populated");
					
					// must completely populate Materials table
					insertMaterial = conn.prepareStatement("insert into materials (modelId, quantity, name, description) values (?, ?, ?, ?)");
					for (Material material : materialList) {
						insertMaterial.setInt(1, material.getModelId());
						insertMaterial.setString(2, material.getQuantity());
						insertMaterial.setString(3, material.getName());
						insertMaterial.setString(4, material.getDescription());
						insertMaterial.addBatch();
					}
					
					insertMaterial.executeBatch();
					
					System.out.println("Materials table populated");					
					
					// must completely populate Application table
					insertApplication = conn.prepareStatement("insert into applications (modelId, beforeClass, beforeImage, duringClass, duringImage) values (?, ?, ?, ?, ?)");
					for (Application application : applicationList) {
						insertApplication.setInt(1, application.getModelId());
						insertApplication.setString(2, application.getBeforeClass());
						insertApplication.setString(3, application.getBeforeImage());
						insertApplication.setString(4, application.getDuringClass());
						insertApplication.setString(5, application.getDuringImage());
						insertApplication.addBatch();
					}
					
					insertApplication.executeBatch();
					
					System.out.println("Applications table populated");					
					
					// must completely populate Ratings table
					insertRating = conn.prepareStatement("insert into ratings (modelId, rate, comment) values (?, ?, ?)");
					for (Rating rating : ratingList) {
						insertRating.setInt(1, rating.getModelId());
						insertRating.setInt(2, rating.getRate());
						insertRating.setString(3, rating.getComment());
						insertRating.addBatch();
					}
		
					insertRating.executeBatch();
					
					System.out.println("Ratings table populated");
					
					// must completely populate Keywords table
					insertKeyword = conn.prepareStatement("insert into keywords (modelId, word) values (?, ?)");
					for (Keyword keyword : keywordList) {
						insertKeyword.setInt(1, keyword.getModelId());
						insertKeyword.setString(2, keyword.getWord());
						insertKeyword.addBatch();
					}
		
					insertKeyword.executeBatch();
					
					System.out.println("Keywords table populated");
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertProfile);
					DBUtil.closeQuietly(insertModel);
					DBUtil.closeQuietly(insertMaterial);
					DBUtil.closeQuietly(insertApplication);
					DBUtil.closeQuietly(insertKeyword);
					DBUtil.closeQuietly(insertRating);
				}
			}					
		});
	}
	

	//Jason's methods 

	@Override
	public List<Rating> findRatingsByModelId(int modelId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int insertApplicationIntoApplicationTable(int modelId, String beforeClass, String beforeImage,
			String duringClass, String duringImage) { return 0; }
	
	public int insertKeywordIntoKeywordTable(int modelId, String word) { return 0; }
	
	public int insertMaterialIntoMaterialTable(int modelId, String name, String quantity, String cost, String buildTime, String description) { return 0;}
	
	
	public Profile findProfileByProfileId(int profileId) { return null; }
	
	@Override
	public PhysicalModel findModelByModelId(int modelId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<PhysicalModel> findModelsByProfileId(int profileId) { return null; }
	
	public List<PhysicalModel> findModelsByMaterialName(String materialName) { return null; }
	
	public List<PhysicalModel> findModelsByCategory(Category category) { return null; }
	
	public List<PhysicalModel> findModelsByKeyword(String keyword) { return null; }
	
	//end of Jason's methods
	

	
	
	//Kate's methods
	@Override
	public List<Material> findMaterialsByModelId(int modelId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Keyword> findKeywordsByModelId(int modelId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override 
	public List<Profile> getAllProfiles(){
		return null;
	}
	
	public int insertModelIntoPhysicalModelTable(String title, String decription, String thumbnail,
			String engPrinciple, String citation, Category category, String procedure) { return 0; }
	
	public List<PhysicalModel> findModelsByTitle(String title) { return null; }
	
	

	@Override
	public List<PhysicalModel> findModelsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int insertModelIntoPhysicalModelTable(int profileId, String title, String decription, String thumbnail,
			String engPrinciple, String citation, Category category, String procedure) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//end of Kate methods
	
	
	
	
	
	//Kaitlyn's methods
	@Override
	public Profile findProfileByModelId(int modelId) {
		//TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Application findApplicationByModelId(int modelId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int insertRatingIntoRatingTable(int modelId, int rate, String comment) { return 0; }

	@Override
	public int insertProfileIntoProfileTable(String firstName, String lastName, String username, String email,
			String password) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<PhysicalModel> findModelsByProfileFirstOrLastName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	//finding models
		public List<PhysicalModel> findModelsByProfileId(Long id) { return null; }
	
	@Override
	public int findProfileIdByUsername(String username) {
		// TODO Auto-generated method stub
		return 0;
	}	
	//end of Kaitlyn's methods

	
}
