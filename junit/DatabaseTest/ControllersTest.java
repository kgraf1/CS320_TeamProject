package DatabaseTest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controllers.*;
import persist.DatabaseProvider;
import persist.FakeDatabase;
import persist.IDatabase;
import model.PhysicalModel;
import model.Material;
import model.Profile;
import model.Category;
import model.Keyword;

public class ControllersTest {
	private IDatabase db = null;
	
	@Before
	public void setUp () throws Exception{
		DatabaseProvider.setInstance(new FakeDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	@Test
	public void testAddApplication() {
		int modelId = 1;
		String test = "test";
		
		AddApplicationController controller = new AddApplicationController();
		assertTrue(controller.create(modelId, test, test, test, test));
	}
	
	@Test
	public void testAddKeywords() {
		int modelId = 1;
		ArrayList<String> test = new ArrayList<String>();
		test.add("test");
		AddKeywordsController controller = new AddKeywordsController();
		assertTrue(controller.create(modelId, test));
		
	}
	
	@Test
	public void testAddMaterials() {
		int modelId = 1;
		ArrayList<String> test = new ArrayList<String>();
		test.add("test");
		test.add("1");
		test.add("test2");
		test.add("test3");
		test.add("test4");
		List<List<String>> test2 = new ArrayList<List<String>>();
		test2.add(test);
		AddMaterialsController controller = new AddMaterialsController();
		assertTrue(controller.create(modelId, test2));
		
	}
	
	@Test
	public void testAddModelSubmission() {
		String test = "test";
		Category cat = Category.STATICS;
		AddModelSubmissionController controller = new AddModelSubmissionController();
		assertTrue(controller.create(test, test,test,test,test,cat ,test) >=0);
		
	}
	
	@Test
	public void testModelsByCategory() {
		String category="CONSTRUCTION";
		ModelsByCategoryController controller = new ModelsByCategoryController();
		ArrayList<PhysicalModel> models = controller.getModelByCategory(category);
		
		assertTrue(!models.isEmpty());
	}
	
	@Test
	public void testModelsByKeyword() {
		ModelsByKeywordController controller = new ModelsByKeywordController();
		assertNotNull(controller.getModelByKeywords("Keyword1"));
		assertNull(controller.getModelByKeywords("Keyword3"));
	}
	
	@Test
	public void testModelsByMaterial() {
		ModelsByMaterialController controller = new ModelsByMaterialController();
		assertNotNull(controller.getModelByMaterialName("Hammer"));
		assertNull(controller.getModelByMaterialName("Keyword1"));
	}
	
	@Test
	public void testModelsByProfileName() {
		ModelsByProfileNameController controller = new ModelsByProfileNameController();
		assertNotNull(controller.getModelByProfileFirstOrLastName("Bob Jones"));
		assertNotNull(controller.getModelByProfileFirstOrLastName("Billy Bob"));
		assertNull(controller.getModelByProfileFirstOrLastName("Bill Omlette"));
	}
	
	@Test
	public void testModelsByTitle() {
		ModelsByTitleController controller = new ModelsByTitleController();
		assertNotNull(controller.getModelByTitle("How bout those stationary thingys"));
		assertNull(controller.getModelByTitle("Does not exist"));
	}
	
}
