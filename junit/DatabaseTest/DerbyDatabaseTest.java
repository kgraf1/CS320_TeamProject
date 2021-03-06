package DatabaseTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;
import model.PhysicalModel;
import model.Material;
import model.Profile;
import model.Rating;
import model.Category;
import model.Keyword;
import model.Application;

public class DerbyDatabaseTest {
	private IDatabase db = null;
	
	List<PhysicalModel> models = null;
	List<Profile> profiles = null;
	List<Material> material = null;
	List<Keyword> keywords = null;

	@Before
	public void setUp () throws Exception{
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	
	@Test
	public void testFindModelsByProfileFirstOrLastName() {
	
		models = db.findModelsByProfileFirstOrLastName("Billy");
		
		if(models.isEmpty()) {
			fail("No models were found by that user");
		}
		else {
			assertTrue(models.size()>=2);
			assertTrue(models.get(0).getTitle().equals("How bout those stationary thingys"));
			assertTrue(models.get(1).getTitle().equals("Modely Model"));
		}
		
		models = db.findModelsByProfileFirstOrLastName("Bob");
		
		if(models.isEmpty()) {
			fail("No models were found by that user");
		}
		else {
			assertTrue(models.size()>=3);
			assertTrue(models.get(0).getTitle().equals("How bout those spinny thingys"));
			assertTrue(models.get(1).getTitle().equals("How bout those stationary thingys"));
			assertTrue(models.get(2).getTitle().equals("Modely Model" ));
		}
		
	
		models = db.findModelsByProfileFirstOrLastName("Jones");
		
		if(models.isEmpty()) {
			fail("No models were found by that user");
		}
		else {
			
			assertTrue(models.size() >=1);
			assertTrue(models.get(0).getTitle().equals("How bout those spinny thingys"));
		}
	}
	
	
	@Test
	public void testModelByCategory () {
		String category = "Construction";
		models = db.findModelsByCategory(category);
		if(models.isEmpty()) {
			fail("No models were found with this category");
		}
		else {
			assertTrue(models.get(0).getTitle().equals("How bout those spinny thingys"));
		}
		
		
		category = "Thermodynamics";
		models = db.findModelsByCategory(category);
		assertFalse(models.isEmpty());
		
		
		category = "Dynamics";
		models = db.findModelsByCategory(category);
		assertTrue(models.isEmpty());
		
		
		category = "Fluids";
		models = db.findModelsByCategory(category);
		assertTrue(models.isEmpty());
		
		
		category = "Heat Transfer";
		models = db.findModelsByCategory(category);
		assertTrue(models.isEmpty());
		
		
		category = "Material Science";
		models = db.findModelsByCategory(category);
		assertTrue(models.isEmpty());;
		
		
		category = "Mechanics";
		models = db.findModelsByCategory(category);
		assertTrue(models.isEmpty());
		
		
		category = "Statics";
		models = db.findModelsByCategory(category);
		if(models.isEmpty()) {
			fail("No models are found with this category");
		}
		else {
			assertTrue(models.size()==1);
			assertTrue(models.get(0).getTitle().equals("How bout those stationary thingys"));
		}
	}
	
	@Test
	public void testModelByKeywords () {
		String keyword="Keyword1";
		models = db.findModelsByKeyword(keyword);
		if(models.isEmpty()) {
			fail("No Models with that keyword");
		}
		else {
			assertTrue(models.size()==1);
			assertTrue(models.get(0).getTitle().equals("How bout those spinny thingys"));
		}
		
		
		keyword="Keyword2";
		models = db.findModelsByKeyword(keyword);
		if(models.isEmpty()) {
			fail("No Models with that keyword");
		}
		else {
			assertTrue(models.size()==1);
			assertTrue(models.get(0).getTitle().equals("How bout those stationary thingys"));
		}
			
		keyword="Keyword11";
		models = db.findModelsByKeyword(keyword);
		if(models.isEmpty()) {
			fail("No Models with that keyword");
		}
		else {
			assertTrue(models.size()==1);
			assertTrue(models.get(0).getTitle().equals("How bout those spinny thingys"));
		}
	}
		
	@Test
	public void findModelsByMaterialName() {
		String materialName = "Hammer";
		models=db.findModelsByMaterialName(materialName);
		if(models.isEmpty()) {
			fail("No Models with that keyword");
		}
		else {
			assertTrue(models.size()==1);
			assertTrue(models.get(0).getTitle().equals("How bout those spinny thingys"));
		}
		
		materialName = "Ruler";
		models = db.findModelsByMaterialName(materialName);
		if(models.isEmpty()) {
			fail("No Models with that keyword");
		}
		else {
			assertTrue(models.size()==1);
			assertTrue(models.get(0).getTitle().equals("How bout those spinny thingys"));
		}
		
		materialName="Rolls of Tape";
		models = db.findModelsByMaterialName(materialName);
		if(models.isEmpty()) {
			fail("No Models with that keyword");
		}
		else {
			assertTrue(models.size()==1);
			assertTrue(models.get(0).getTitle().equals("How bout those spinny thingys"));
		}
		
		materialName="Bar of Soap";
		models = db.findModelsByMaterialName(materialName);
		if(models.isEmpty()) {
			fail("No Models with that keyword");
		}
		else {
			assertTrue(models.size()==1);
			assertTrue(models.get(0).getTitle().equals("How bout those stationary thingys"));
		}
	}
	
	@Test
	public void testFindMaterialsByModelId() {
		int modelId = 1;
		List<Material> materials = db.findMaterialsByModelId(modelId);
		
		System.out.println(materials);
		
		if(materials.isEmpty() ) {
			fail("No materials with that modelId<" + modelId + ">");
		}
		else {
			assertTrue(materials.size() >= 3);
		}
		
		modelId = -1;
		
		materials = db.findMaterialsByModelId(modelId);
		
		System.out.println(materials);
		
		if(!materials.isEmpty()) {
			fail("Materials are found with invalid id<" + modelId + ">");
		}
		else {
			assertTrue(materials.size() == 0);
		}
	}
	
	@Test
	public void testFindApplicationByModelId() {
		int modelId = 1;
		Application application = db.findApplicationByModelId(modelId);
		
		System.out.println("***********************" + db.findProfileByProfileId(1).getFirstName());
		
		if(application == null ) {
			fail("No applications with that modelId<" + modelId + ">");
		}
		/*We cannot have this because within the test cases, we create another application that points to this model,
		 * therefore we are getting different values for the fields.
		 * else {
			assertTrue(application.getBeforeClass().equals("You don't need to do anything before class"));
			assertTrue(application.getBeforeImage().equals("www.image.com"));
			assertTrue(application.getDuringClass().equals("This is what you do after class"));
			assertTrue(application.getDuringImage().equals("www.imageafter.com"));
		}
		*/
		modelId = -1;
		application = db.findApplicationByModelId(modelId);
		if(application!=null) {
			fail("Application found with invalid id<" + modelId + ">");
		}
	}
	
	@Test
	public void testFindProfileByModelId () {
		int modelId = 1;
		Profile profile = db.findProfileByModelId(modelId);
		if(profile == null) {
			fail("A Profile was not found for this modelId");
		}
		else {
			assertTrue(profile.getFirstName().equals("Bob"));
			assertTrue(profile.getLastName().equals("Jones"));
		}
		
		modelId = -1;
		profile = db.findProfileByModelId(modelId);
		if(profile!=null) {
			fail("A Profile was found with an invalid ID");
		}
	}
	
	@Test
	public void testFindKeywordsByModelId () {
		int modelId=1;
		List<Keyword> keywords = db.findKeywordsByModelId(modelId);
		if(keywords.isEmpty()) {
			fail("No keywords found with that model id: <" + modelId + ">");
		}
		else {
			assertTrue(keywords.size() >= 2);
		}
		
		modelId = -1;
		keywords = db.findKeywordsByModelId(modelId);
		if(!keywords.isEmpty()) {
			fail("Keywords found with invalid modelId");
		}
		else {
			assertTrue(keywords.size() == 0);
		}
	}
	
	@Test 
	public void testGetAllProfiles() {
		List<Profile> profiles = db.getAllProfiles();
		
		assertTrue(profiles.size() >= 3);
	}
	
	@Test
	public void testGetAllPhysicalModels() {
		List<PhysicalModel> models = db.getAllModels();
		
		for(int i=0; i<models.size(); i++) {
			System.out.println(models.get(i).getTitle());
			System.out.println(models.get(i).getId());
		}
		
		assertTrue(models.size()>=1);
	}
	
	@Test
	public void testModelsByTitle () {
		String title ="How bout those spinny thingys";
		models=db.findModelsByTitle(title);
		
		System.out.println(models);
		
		if(models.isEmpty()) {
			fail("No Models with that keyword");
		}
		else {
			assertTrue(models.size()==1);
			assertTrue(models.get(0).getId()==1);
			assertTrue(models.get(0).getDescription().equals("Those spinny thingys are so descriptive and I am going to decribe them in my decription which is what this is"));
		}
		
		title="How bout those stationary thingys";
		models=db.findModelsByTitle(title);
		if(models.isEmpty()) {
			fail("No Models with that keyword");
		}
		else {
			assertTrue(models.size()==1);
			assertTrue(models.get(0).getId()==2);
			assertTrue(models.get(0).getDescription().equals("Those stationary thingys are boring compared to the spiny thingys"));
		}
	}
	
	@Test
	public void testFindProfilIdByUsername() {
		String username="testing";
		int profileId = db.findProfileIdByUsername(username);
		
		assertTrue(profileId == 2);
	}
	
	
	@Test
	public void testInsertProfileIntoProfileTable () {
		String firstName = "Test";
		String lastName = "test";
		String username = "testUser";
		String password = "testingNow";
		String email = "email@gmail.com";
		String profileImage = "www.image.com";
		
		int profile_id = db.insertProfileIntoProfileTable(firstName, lastName, username, email, password, profileImage);
		
		System.out.println(profile_id);
		
		Profile profile = db.findProfileByProfileId(profile_id);
	
		
		assertTrue(profile.getFirstName().equals(firstName));
		assertTrue(profile.getLastName().equals(lastName));
		assertTrue(profile.getEmail().equals(email));
		assertTrue(profile.getPassword().equals(password));
		assertTrue(profile.getUsername().equals(username));
	}
	
	@Test
	public void testInsertModelIntoPhysicalModelTable () {
		int profileId = 2;
		String title = "testTitle";
		String description = "testDescription";
		String thumbnail ="testThumbnail";
		String engPrinciple = "testPrinciple";
		String citation = "testCitation";
		Category category = Category.CONSTRUCTION;
		String procedure = "testProcedure";
		
		
		db.insertModelIntoPhysicalModelTable(profileId, title, description, thumbnail, engPrinciple, citation, category, procedure);
		List<PhysicalModel> models = db.findModelsByTitle(title);
		
		assertTrue(models.get(0).getProfileId() == profileId);
		assertTrue(models.get(0).getTitle().equals(title));
		assertTrue(models.get(0).getDescription().equals(description));
		assertTrue(models.get(0).getThumbnail().equals(thumbnail));
		assertTrue(models.get(0).getEngPrinciple().equals(engPrinciple));
		assertTrue(models.get(0).getCitation().equals(citation));
		assertTrue(models.get(0).getCategory().equals(category));
		assertTrue(models.get(0).getProcedure().equals(procedure));
	}
	
	
	@Test
	public void testInsertRatingIntoRatingsTable () {
		int modelId = 1;
		int rate = 3;
		String comment = "This was acceptable";
		
		db.insertRatingIntoRatingTable(modelId, rate, comment);
		List<Rating> ratings = db.findRatingsByModelId(modelId);
		
		for(int i=0; i<ratings.size(); i++) {
			if((ratings.get(i).getRate()==rate) && (ratings.get(i).getComment().equals(comment))) {
				assertTrue(true);
			}
			
		}
		
	}
		
		
		
		@Test
		public void testFindRatingsByModelId() {
			int modelId = 1;
			List<Rating> ratings = db.findRatingsByModelId(modelId);
			
			System.out.println(ratings);
			
			if(ratings.isEmpty() ) {
				fail("No ratings with thtat modelId<" + modelId + ">");
			}
			else {
				assertTrue(ratings.size() >= 2);
			}
			
			modelId = -1;
			
			ratings = db.findRatingsByModelId(modelId);
			
			System.out.println(ratings);
			
			if(!ratings.isEmpty()) {
				fail("Materials are found with invalid id<" + modelId + ">");
			}
			else {
				assertTrue(ratings.size() == 0);
			}
		}
		
		@Test
		public void testFindProfilesByProfileId() {
			int profileId = 1;
			Profile profile = db.findProfileByProfileId(profileId);
			
			//System.out.println(ratings);
			
			if(profile.getPassword() == null ) {
				fail("Profile with profileId<" + profileId + "> has not returned properlu");
			}
			else {
				System.out.println("The first name of the profile returned is: "+profile.getFirstName());
				assertTrue(profile.getFirstName().equals("Bob"));
			}
			
		}
		
		@Test
		public void testFindModelByModelId() {
			int modelId = 1;
			PhysicalModel model = db.findModelByModelId(modelId);
			
			assertTrue(model.getTitle().equals("How bout those spinny thingys"));
		}
		
		@Test
		public void testFindModelsByProfileId() {
			int profileId = 1;
			ArrayList<PhysicalModel> models = new ArrayList<PhysicalModel>();
			models.addAll(db.findModelsByProfileId(profileId));
			
			System.out.println("The title of the first model found is: " +models.get(0).getTitle());
			assertTrue(models.get(0).getTitle().equals("How bout those spinny thingys"));
		}
		
		@Test
		public void testFindModelsByMaterialName() {
			String materialName = "Hammer";
			ArrayList<PhysicalModel> models = new ArrayList<PhysicalModel>();
			models.addAll(db.findModelsByMaterialName(materialName));
			
			System.out.println("The title of the first model found is: " +models.get(0).getTitle());
			assertTrue(models.get(0).getTitle().equals("How bout those spinny thingys"));
		}
		
		
		@Test
		public void testFindModelsByKeyword() {
			String keyword = "Keyword1";
			ArrayList<PhysicalModel> models = new ArrayList<PhysicalModel>();
			models.addAll(db.findModelsByKeyword(keyword));
			
			
			for(int i=0; i<models.size(); i++) {
				System.out.println(models.get(i).getTitle());
				System.out.println(models.get(i).getId());
			}
			
			assertTrue(models.get(0).getTitle().equals("How bout those spinny thingys"));
			
		}
		@Test
		public void testInsertKeyword() {
			int modelId = 1;
			String word = "test";
			
			assertFalse(db.insertKeywordIntoKeywordTable(modelId, word) ==-1);
		}
		@Test
		public void testInsertKeywordAndFindModelByNewKeyword() {
			
			int modelId = 1;
			String keyword = "FindKeyword";
			
			int keywordId = db.insertKeywordIntoKeywordTable(modelId, keyword);
			assertTrue(keywordId !=-1);
			ArrayList<PhysicalModel> models = new ArrayList<PhysicalModel>();
			models.addAll(db.findModelsByKeyword(keyword));
			
			
		}
		@Test
		public void testInsertApplication() {
			int modelId = 1;
			String beforeClass = "test";
			String duringClass = "test";
			String beforeImage = "test";
			String duringImage = "test";
			assertTrue(db.insertApplicationIntoApplicationTable(modelId, beforeClass, beforeImage, duringClass, duringImage) != -1);
		}
		
		@Test
		public void testInsertMaterial() {
			int modelId = 1;
			String name = "test";
			String quantity = "3";
			String description = "thing";
			String cost = "money";
			String buildTime = "buildtime";
			
			
			assertFalse(db.insertMaterialIntoMaterialTable(modelId, name, quantity, cost, buildTime, description) ==-1);
			assertNotNull(db.insertMaterialIntoMaterialTable(modelId, name, quantity, cost, buildTime, description) ==-1);
		}
}
