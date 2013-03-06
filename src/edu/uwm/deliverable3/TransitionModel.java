package edu.uwm.deliverable3;

/*Program Created by Software Engineering Group: 13013 (BoB)*/
		//Alex Hart
		//Michael Adler
		//Brady Moe

public class TransitionModel {

	private String name;
	private StateModel succesor = new  StateModel();
	private StateModel predecesor = new StateModel();
	
	//Constructors
	public TransitionModel(String name, StateModel from, StateModel to){
		
		this.name = name;
		succesor = to;
		predecesor = from;
		
	}
	//No Name Argument.
	public TransitionModel(StateModel from, StateModel to){
		
		this.name = "Transition";
		this.succesor = to;
		this.predecesor = from;
		
	}
	
	//Getters
	public StateModel getSuccesor(){
		
		return succesor;
		
	}
	
	public StateModel getPredecesors(){
		
		return predecesor;
		
	}
	
	//Output to XML
	public String toXML(){
		
		if(this.name == null){throw new NullPointerException("Transition not initialized.");}		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("		<transition name=\"" + name + "\">\n");
		sb.append("				<transitionFrom>"+predecesor.getName()+"</transitionFrom>\n");
		sb.append("				<transitionTo>"+succesor.getName()+"</transitionTo>\n");
		sb.append("		</transition>\n");
		
		return sb.toString();
	}
	
}
