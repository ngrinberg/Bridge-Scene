package main;
	import interfaces.Locaterface;
import interfaces.PropertyListenerSupport;
import interfaces.Universe;

	import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import util.annotations.EditablePropertyNames;
import util.annotations.Explanation;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
	@StructurePattern(StructurePatternNames.LINE_PATTERN)
	@Explanation("Uses Cartesian representation.")
	@PropertyNames({"x","y","full"})
	@EditablePropertyNames({"x","y" })
public abstract class MyLocatable implements Locaterface {	
		int x, y;
		Universe aUniverse;
		
		PropertyListenerSupport propertySupport= new APropertyListenerSupport();
		    public MyLocatable  (int initX, int initY) {// grabs initial values from driver set to 20 at first
		        x = initX; // assigning properties values
		        y = initY;
		        
		        
		      
		    }
		  
		    
		    public int getX() {return x;}//use for later
		    public void setX(int newX) {
		    	int oldX=x;
		    	x = newX;
		    	propertySupport.notifyAllListeners(new PropertyChangeEvent(this,//notifies the change in X
							"X", oldX, newX));}
		    public int getY() {return y;}
		   
		    public void setY(int newY) {
		    	int oldY=y;
		    	y = newY;
		    
		    	propertySupport.notifyAllListeners(new PropertyChangeEvent(this,
					"Y", oldY, newY));
		    }
		    
		    @Override
		    public void addPropertyChangeListener(PropertyChangeListener listener) {// adds a property change type to the collection
		    	propertySupport.add(listener);  //calls add() and passes through the type
		    }
		
	
	
	}

