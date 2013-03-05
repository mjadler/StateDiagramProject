package edu.uwm.deliverable3;

import java.util.ArrayList;
import java.util.List;

/*Program Created by Software Engineering Group: 13013 (BoB)*/
		//Alex Hart
		//Michael Adler
		//Brady Moe

/*A Class to model the states of a UML diagram */
public class StateModel {
	
		private String name;
		private List<TransitionModel> pointers = new ArrayList<TransitionModel>();
		
		//Constructors
		
		public StateModel(String name){
			
			this.name = name;
				
		}
		
		public StateModel(){
			
			this.name = "";
			
		}
		
		//Getters
		public List<TransitionModel> getSuccesors(){
			
			return pointers;
			
		}
		
		public String getName(){
			
			return this.name;
			
		}
		
		public boolean editName(String newName){
			
			if(newName != this.name){
				this.name = newName;
				return true;
			}
			else return false;
			
		}
		
		//Setters
		public void addTransition(TransitionModel tm){
			
			if(tm == null){
					throw new NullPointerException("Cannot have a null transition");
			}
			if(tm.getSuccesor() == this){
					throw new IllegalArgumentException("Cannot transition to itself");
			}
			else pointers.add(tm);
		}

		//Output as XML
		public String toXML(){
				
			StringBuilder sb = new StringBuilder();
				
			sb.append("<state name=\""+name+"\">\n" );
			for(int i = 0; i< pointers.size(); i++){
				sb.append("		"+pointers.get(i).toXML());
			}
			sb.append("</state>\n");
			
			return sb.toString();
				
				
		}
		
		
	

}
