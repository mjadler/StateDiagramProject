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

	@Test
	public void testTransitionNotAdded() {
		
		assertFalse(defaultStateModel.addTransition(null));
		assertEquals(0 , defaultStateModel.getSuccesors().size());
		
	}
	
	@Test
	public void testTransitionAlreadyAdded(){ 
		
		StateModel otherStateModel = new StateModel();
		TransitionModel t1 = new TransitionModel(defaultStateModel,otherStateModel);
		assertTrue(defaultStateModel.addTransition(t1));
		assertFalse(defaultStateModel.addTransition(t1));
		
	}
	
	
	//MIKEY TESTS
	@Test
	public void testTranitionToSelf(){
		
		defaultTransition = new TransitionModel("jfdkljdfs", defaultStateModel, defaultStateModel);
		assertFalse(defaultStateModel.addTransition(defaultTransition));		
			
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
	
	//Alex Tests
	@Test
	public void testXML(){
		StateModel sm1 = new StateModel("one");
		StateModel sm2 = new StateModel("two");
		TransitionModel tm1 = new TransitionModel("t1to2", sm1, sm2);
		
		String NASTYXMLSTRING = 
				"<state name=\"one\">\n"+
				"		<transition name=\"t1to2\">\n"+
				"				<transitionFrom>one</transitionFrom>\n"+
				"				<transitionTo>two</transitionTo>\n"+
				"</transition>\n"+
				"</state>\n";
		
		System.out.println(NASTYXMLSTRING);
		System.out.println(sm1.toXML());
		
		assertEquals(sm1.toXML(), NASTYXMLSTRING);
	}
}
