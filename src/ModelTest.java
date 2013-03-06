import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.uwm.deliverable3.*;


public class ModelTest {
	
	private StateModel defaultStateModel;
	private TransitionModel defaultTransition;
	
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
	
	@Test
	public void testTranitionToSelf(){
		
		defaultTransition = new TransitionModel("newTrans", defaultStateModel, defaultStateModel);
		assertFalse(defaultStateModel.addTransition(defaultTransition));		

	}
	
	
	
	@Test
	public void testPathForwardEqualsBackward(){
		
		//creating states
		StateModel sm1 = new StateModel("one");
		StateModel sm2 = new StateModel("two");
		StateModel sm3 = new StateModel("three");
		StateModel sm4 = new StateModel("four");
		
		//creating transitions
		TransitionModel tm1 = new TransitionModel("t1to2",sm1,sm2);
		TransitionModel tm2 = new TransitionModel("t2to3",sm2,sm3);
		TransitionModel tm3 = new TransitionModel("t3to4",sm3,sm4);
		TransitionModel tm4 = new TransitionModel("t4to1",sm4,sm1);
		
		//connecting transitions to states
		sm1.addTransition(tm1);
		sm2.addTransition(tm2);
		sm3.addTransition(tm3);
		sm3.addTransition(tm4);
		
		//testing going backwards
		assertEquals(sm1, tm1.getPredecesors());
		assertEquals(sm2, tm2.getPredecesors());
		assertEquals(sm3, tm3.getPredecesors());
		assertEquals(sm4, tm4.getPredecesors());

		//testing going forward
		assertEquals(sm1, tm4.getSuccesor());
		assertEquals(sm2, tm1.getSuccesor());
		assertEquals(sm3, tm2.getSuccesor());
		assertEquals(sm4, tm3.getSuccesor());
		
	}
	
	
	@Test
	public void testMultipleTransitions(){
		//creating states
		StateModel sm1 = new StateModel("one");
		StateModel sm2 = new StateModel("two");
		StateModel sm3 = new StateModel("three");
		StateModel sm4 = new StateModel("four");
		
		//creating transitions
		TransitionModel tm1 = new TransitionModel("t1to2",sm1,sm2);
		TransitionModel tm2 = new TransitionModel("t1to3",sm1,sm3);
		TransitionModel tm3 = new TransitionModel("t1to4",sm1,sm4);
		
		//connecting transitions to states
		sm1.addTransition(tm1);
		sm1.addTransition(tm2);
		sm1.addTransition(tm3);
		
		//check to make sure that all three transitions are in transition list
		int i = 0;
		assertEquals(tm1, sm1.getSuccesors().get(0));
		//assertEquals(sm1,sm1.getSuccesors().get(1).getPredecesors());
		//assertEquals(sm1,sm1.getSuccesors().get(2).getPredecesors());
		
	}
	
	//Alex Tests
	@Test
	public void testXML(){
		StateModel sm1 = new StateModel("one");
		StateModel sm2 = new StateModel("two");
		TransitionModel tm1 = new TransitionModel("t1to2", sm1, sm2);
		
		sm1.addTransition(tm1);
		
		String NASTYXMLSTRING = 
				"<state name=\"one\">\n"+
				"		<transition name=\"t1to2\">\n"+
				"				<transitionFrom>one</transitionFrom>\n"+
				"				<transitionTo>two</transitionTo>\n"+
				"		</transition>\n"+
				"</state>\n";
		
		System.out.println(NASTYXMLSTRING);
		System.out.println(sm1.toXML());
		
		assertEquals(sm1.toXML(), NASTYXMLSTRING);
	}
}
