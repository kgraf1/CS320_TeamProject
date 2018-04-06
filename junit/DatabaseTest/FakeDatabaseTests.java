package DatabaseTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import persist.DatabaseProvider;
import persist.FakeDatabase;
import persist.IDatabase;
import model.PhysicalModel;
import model.Material;
import model.Profile;
import model.Keyword;

public class FakeDatabaseTests {
	private IDatabase db = null;
	
	List<PhysicalModel> models = null;
	List<Profile> profiles = null;
	List<Material> material = null;
	List<Keyword> keywords = null;

	@Before
	public void setUp () throws Exception{
		DatabaseProvider.setInstance(new FakeDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	@Test
	public void testFindModelsByProfileFirstOrLastName() {
		String name="Billy";
		models = db.findModelsByProfileFirstOrLastName(name);
		
		if(models.isEmpty()) {
			fail("No models were found by that user");
		}
		else {
			assertTrue(models.size()==1);
			assertTrue(models.get(0).getTitle().equals("How bout those stationary thingys"));
		}
		
		name="Bob";
		models = db.findModelsByProfileFirstOrLastName(name);
		
		if(models.isEmpty()) {
			fail("No models were found by that user");
		}
		else {
			assertTrue(models.size()==2);
			assertTrue(models.get(0).getTitle().equals("How bout those spinny thingys"));
			assertTrue(models.get(1).getTitle().equals("How bout those stationary thingys"));
		}
		
		name="Jones";
		models = db.findModelsByProfileFirstOrLastName(name);
		
		if(models.isEmpty()) {
			fail("No models were found by that user");
		}
		else {
			assertTrue(models.size()==1);
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
			assertTrue(models.size()==1);
			assertTrue(models.get(0).getTitle().equals("How bout those spinny thingys"));
		}
		
		
		category = "Thermodynamics";
		models = db.findModelsByCategory(category);
		assertTrue(models.isEmpty());
		
		
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
		public void testModelsByTitle () {
			String title ="How bout those spinny thingys";
			models=db.findModelsByTitle(title);
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
}
