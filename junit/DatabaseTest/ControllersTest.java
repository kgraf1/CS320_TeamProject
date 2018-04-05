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
import model.Keyword;

public class ControllersTest {
	private IDatabase db = null;
	
	@Before
	public void setUp () throws Exception{
		//DatabaseProvider.setInstance(new FakeDatabase());
		//db = DatabaseProvider.getInstance();
	}
	
	@Test
	public void testAddApplication() {
		int modelId = 0;
		String test = "test";
		
		AddApplicationController controller = new AddApplicationController();
		assertTrue(controller.create(modelId, test, test, test, test));
		assertFalse(controller.create(modelId, test, test, test, test));
	}
	
	@Test
	public void testAddKeywords() {
		int modelId = 0;
		List<String> test;
		
		//AddKeywordsController controller = new AddKeywordsController();
		//assertTrue(controller.create(modelId, test, test, test, test));
		//assertFalse(controller.create(modelId, test, test, test, test));
	}
	
	@Test
	public void testModelsByCategoryController() {
		String category="Construction";
		ModelsByCategoryController controller = new ModelsByCategoryController();
		ArrayList<PhysicalModel> models = controller.getModelByCategory(category);
		
		assertTrue(!models.isEmpty());
	}
}
