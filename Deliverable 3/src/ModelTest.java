import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.uwm.deliverable3.*;


public class ModelTest {
	
	private StateModel defaultStateModel;

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
	public void testTransitionAlreadyAdded(){
		
		StateModel other = new StateModel();
		TransitionModel tran1 = new TransitionModel("1",other,defaultStateModel);
		defaultStateModel.addTransition(tran1);
		assertEquals(1, defaultStateModel.getSuccesors().size());
		defaultStateModel.addTransition(tran1);
		assertEquals(1, defaultStateModel.getSuccesors().size());
		
	}

}
