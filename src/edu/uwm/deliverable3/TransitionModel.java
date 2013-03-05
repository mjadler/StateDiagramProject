package edu.uwm.deliverable3;

/*Program Created by Software Engineering Group: 13013 (BoB)*/
		//Alex Hart
		//Michael Adler
		//Brady Moe

public class TransitionModel {

	private String name;
	private StateModel succesor = new  StateModel();
	private StateModel predecesor = new StateModel();
	
	//Constructor
	public TransitionModel(String name, StateModel from, StateModel to){
		
		this.name = name;
		succesor = to;
		predecesor = from;
		
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
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<transition name=\"" + name + "\">\n");
		sb.append("				<transitionFrom>"+predecesor.getName()+"</transitionFrom>\n");
		sb.append("				<transitionTo>"+succesor.getName()+"</transitionTo>");
		sb.append("</task>\n");
		
		return sb.toString();
	}
	
}
