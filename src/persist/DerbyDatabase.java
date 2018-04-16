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
		Connection conn = DriverManager.getConnection("jdbc:derby:C:/Users/katek/git/CS320_TeamProject/database.db;create=true");		
		
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
				PreparedStatement stmt4 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;
			
				try {
					stmt1 = conn.prepareStatement(
							"create table profiles (" +
							"	profile_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	username varchar(70)," +
							"	password varchar(15)," +
							"   firstName varchar(50)," +
							"   lastName varchar(50)," + 
							"   email varchar(50)" +
							")"
					);
					stmt1.executeUpdate();
					
					System.out.println("Profiles table created");	
					
					stmt2 = conn.prepareStatement(
						"create table models (" +
						"	model_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +	
						"   profile_id integer constraint profile_id references profiles," + 
						"   title varchar(40)," +
						"   description varchar(250)," + 
						"   thumbnail varchar(100)," + 
						"   engPrinciple varchar(100)," +
						"   citation varchar(100)," +
						"   category varchar(20)," +
						"   steps varchar(150)" +
						")"
					);	
					stmt2.executeUpdate();
					
					System.out.println("Models table created");				
					
					stmt3 = conn.prepareStatement(
							"create table materials (" +
							"	material_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	material_model_id integer constraint material_model_id references models," +
							"	quantity float," +
							"   name varchar(50)," +
							"   description varchar(100)" + 
							")"
					);
					stmt3.executeUpdate();					
					
					System.out.println("Materials table created");	
					
					stmt4 = conn.prepareStatement(
							"create table ratings (" +
							"	rating_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	rating_model_id integer constraint rating_model_id references models," +
							"	rate float," +
							"   comment varchar(70)" +
							")"
					);
					stmt4.executeUpdate();
					
					System.out.println("Ratings table created");
					
					stmt5 = conn.prepareStatement(
							"create table keywords (" +
							"	keyword_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	keyword_model_id integer constraint keyword_model_id references models," +
							"	word varchar(50)" +
							")"
					);
					stmt5.executeUpdate();
					
					System.out.println("Keywords table created");	
					
					stmt6 = conn.prepareStatement(
							"create table applications (" +
							"	application_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	application_model_id integer constraint applciation_model_id references models," +
							"	beforeClass varchar(150)," +
							"   beforeImage varchar(150)," +
							"   duringClass varchar(150)," +
							"   duringImage varchar(150)" +
							")"
					);
					stmt6.executeUpdate();
					
					System.out.println("Application table created");	
					
										
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(stmt4);
					DBUtil.closeQuietly(stmt5);
					DBUtil.closeQuietly(stmt6);
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
					insertModel = conn.prepareStatement("insert into models (profile_id, title, description, thumbnail, engPrinciple, citation,"
							+ "category, steps) values (?, ?, ?, ?, ?, ?, ?, ?)");
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
					insertMaterial = conn.prepareStatement("insert into materials (material_model_id, quantity, name, description) values (?, ?, ?, ?)");
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
					insertApplication = conn.prepareStatement("insert into applications (application_model_id, beforeClass, beforeImage, duringClass, duringImage) values (?, ?, ?, ?, ?)");
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
					insertRating = conn.prepareStatement("insert into ratings (rating_model_id, rate, comment) values (?, ?, ?)");
					for (Rating rating : ratingList) {
						insertRating.setInt(1, rating.getModelId());
						insertRating.setInt(2, rating.getRate());
						insertRating.setString(3, rating.getComment());
						insertRating.addBatch();
					}
		
					insertRating.executeBatch();
					
					System.out.println("Ratings table populated");
					
					// must completely populate Keywords table
					insertKeyword = conn.prepareStatement("insert into keywords (keyword_model_id, word) values (?, ?)");
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
	public Profile findProfileByModelId(final int modelId) {
		return executeTransaction(new Transaction <Profile> () {
			@Override
			public Profile execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				//try to retrieve profile by modelId
				try {
					stmt = conn.prepareStatement(
							"select profiles.*" + 
							"from profiles, models" +
							"where models.id = ?" +
							"and profiles.id = models.profile_id" 
					);
					stmt.setInt(1, modelId);
					
					//execute the query, get the result
					resultSet = stmt.executeQuery();
					Profile profile = new Profile();
					loadProfile(profile, resultSet, 1);
					
					return profile;
				}
				finally{
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	
	@Override
	public Application findApplicationByModelId(final int modelId) {
		return executeTransaction(new Transaction <Application> () {
			@Override
			public Application execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				//try to retrieve profile by modelId
				try {
					stmt = conn.prepareStatement(
							"select applications.*" + 
							"from applications, models" +
							"where models.id = ?" +
							"and applications.model_id = models.id" 
					);
					stmt.setInt(1, modelId);
					
					//execute the query, get the result
					resultSet = stmt.executeQuery();
					Application application = new Application();
					loadApplication(application, resultSet, 1);
					
					return application;
				}
				finally{
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	public int insertRatingIntoRatingTable(final int modelId, final int rate, final String comment) {
		return executeTransaction (new Transaction <Integer>() {
			@Override
			public Integer execute(Connection conn)throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				ResultSet resultSet = null;
							
				
				//for saving model id and rating id
				Integer rating_id = -1;
				
				try {
					//insert new rating into rating table
					//prepare SQL insert statement to add new rating to rating table
					stmt1 = conn.prepareStatement(
							"insert into rating (model_id, rate, comment) " +
									" values(?, ?, ?) "
					);
					stmt1.setInt(1, modelId);
					stmt1.setInt(2, rate);
					stmt1.setString(3, comment);
				
					//execute the update
					stmt1.executeUpdate();
				
					System.out.println("New rating <" + rate + "> inserted into Ratings table"); 
				
					//now retrieve rating_id to check that it inserted correctly
					//prepare SQl statement to retrieve rating_id for new Rating
					stmt2 = conn.prepareStatement(
							"select rating_id from ratings" +
									"where rating = ? and comment = ?"
					);
					stmt2.setInt(1, rate);
					stmt2.setString(2, comment);
					
					//executeQuery 
					resultSet = stmt2.executeQuery();
					
					//get the result
					if(resultSet.next()) {
						rating_id = resultSet.getInt(1);
						System.out.println("New rating <" + rate + "> ID:" + rating_id);
					}
					else {
						System.out.print("New rating <" + rate +"> not found in Ratings table");
					}
					
					return rating_id;
				}
				finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
	}

	@Override
	public int insertProfileIntoProfileTable(final String firstName, final String lastName, final String username, final String email,
			final String password) {
		return executeTransaction (new Transaction <Integer>() {
			@Override
			public Integer execute(Connection conn)throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;
				ResultSet resultSet1 = null;
				ResultSet resultSet2 = null;
							
				
				//for saving model id and rating id
				Integer profile_id = -1;
				
				try {
					//try to retrieve profile_id from DB
					stmt1 = conn.prepareStatement(
							"select profile_id from profiles" +
							"where username=? and password=?"
					);
					stmt1.setString(1, username);
					stmt1.setString(2, password);
					
					//execute the query, get the result
					resultSet1 = stmt1.executeQuery();
					
					//if Profile was found, then save profile_id
					if(resultSet1.next()) {
						profile_id = resultSet1.getInt(1);
						System.out.println("User <" + firstName + " " + lastName + "> already exists");
					}
					else {
						System.out.println("User <" + firstName + " " + lastName + "> not found, continue inserting");
						
						//if the Profile is new, insert new Profile into profiles table 
						//insert new profile into profile table
						//prepare SQL insert statement to add new rating to rating table
						stmt2 = conn.prepareStatement(
								"insert into profiles (firstName, lastName, username, email, password) " +
										" values(?, ?, ?, ?, ?, ?) "
						);
						stmt2.setString(1, firstName);
						stmt2.setString(2, lastName);
						stmt2.setString(3, username);
						stmt2.setString(4,  email);
						stmt2.setString(5, password);
					
						//execute the update
						stmt2.executeUpdate();
					
						System.out.println("New user <" + firstName + " " + lastName + "> inserted into Profiles table"); 
					
					}
					
					//try to retrieve profile_id for new profile
					stmt3 = conn.prepareStatement(
							"select profile_id from profiles" +
							"where username = ? and password = ?"
					);
					stmt3.setString(1, username);
					stmt3.setString(2, password);
					
					//execute the query
					resultSet2 = stmt3.executeQuery();
					
					//get the result
					if(resultSet2.next()) {
						profile_id = resultSet2.getInt(1);
						System.out.println("New user <" + firstName + " " + lastName + "> ID: " + profile_id);
					}
					else {
						System.out.println("Insertion of new user failed");
					}
					return profile_id;
				}
				finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(resultSet2);
				}
			}
		});
	}
	
	
	@Override
	public List<PhysicalModel> findModelsByProfileFirstOrLastName(final String name) {
		return executeTransaction (new Transaction<List<PhysicalModel>>() {
			@Override
			public List<PhysicalModel> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select models.*" + 
							"from models, profiles" +
							"where profiles.firstName LIKE %?% and profiles.lastName LIKE %?%" +
							"and profiles.id = models.profile_id"
					);
					
					stmt.setString(1, name);
					stmt.setString(2, name);
					
					List<PhysicalModel> result = new ArrayList<PhysicalModel>();
					
					resultSet = stmt.executeQuery();
							
					//for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						PhysicalModel model = new PhysicalModel();
						loadModel (model, resultSet, 1);
						
						result.add(model);
					}
					
					
					return result;
				}
				finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	@Override
	public int findProfileIdByUsername(final String username) {
		return executeTransaction (new Transaction <Integer> () {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				Integer profile_id = -1;
				
				try {
					stmt = conn.prepareStatement(
						"select profiles.*"
						+ "from profiles"
						+ "where profiles.username = ?"
					);
					stmt.setString(1, username);
					
					resultSet = stmt.executeQuery();
					
					if (resultSet.next()) {
						profile_id = resultSet.getInt(1);
						System.out.println("Profile id: " + profile_id + "was retrieved");
					}
					else {
						System.out.println("Profile was not retrieved successfully");
					}
					
					return profile_id;
				}
				finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
	}	
	//end of Kaitlyn's methods

	
}
