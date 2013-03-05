import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.uwm.deliverable3.*;


public class ModelTest {
	
	private StateModel defaultStateModel;
	private TransitionModel defaultTransition;

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
	public void testTransitionAlreadyAdded(){ 
		
		
		
	}
	
	
	//MIKEY TESTS
	@Test (expected = IllegalArgumentException.class)
	public void testTranitionToSelf(){
		
		defaultTransition = new TransitionModel("jfdkljdfs", defaultStateModel, defaultStateModel);
		defaultStateModel.addTransition(defaultTransition);		
		
	}
	
	public void testPathForwardEqualsBackward(){
		
		StateModel sm1 = new StateModel("one");
		StateModel sm2 = new StateModel("two");
		StateModel sm3 = new StateModel("three");
		StateModel sm4 = new StateModel("four");
		TransitionModel tm1 = new TransitionModel("t1to2",sm1,sm2);
		TransitionModel tm2 = new TransitionModel("t2to3",sm2,sm3);
		TransitionModel tm3 = new TransitionModel("t3to4",sm3,sm4);
		TransitionModel tm4 = new TransitionModel("t4to1",sm4,sm1);
		sm1.addTransition(tm1);
		sm2.addTransition(tm2);
		sm3.addTransition(tm3);
		sm3.addTransition(tm4);
		
		
		
	}
	
	
}
