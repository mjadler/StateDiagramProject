import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.uwm.deliverable3.*;


public class ModelTest {
	
	private StateModel defaultStateModel;

	//BRADY TESTS
	
	@Before
	public void constructModel() {
		
		defaultStateModel = new StateModel("Default");
		
	}

	@Test (expected = NullPointerException.class)
	public void testTransitionNotAdded() {
		
		defaultStateModel.addTransition(null);
		assertEquals(0 , defaultStateModel.getSuccesors().size());
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testTransitionAlreadyAdded(){ }
	
	//MIKEY TESTS
	@Test (expected = IllegalArgumentException.class)
	public void testTranitionToSelf(){
		
		
		
	}
	
	
}
