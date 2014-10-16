package main;
import interfaces.Ovalterface;

import java.awt.Color;





import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.OVAL_PATTERN)

@Tags({"Bounded Shape"})

@PropertyNames({"filled","color","x","y","height","width" })

@EditablePropertyNames({ "x", "y", "width", "height" })

public class Oval extends MyBoundedShape implements Ovalterface{
	
	boolean filled;
	Color color;
	    
	    public Oval  (int initX, int initY, int initHeight, int initWidth,Color newColor) {// grabs initial values from driver set to 20 at first
	   super(initX,initY,initHeight,initWidth);// calls super class to do the work for it
	      color=newColor;
	      filled=false;
	      
	    }
	    public boolean getFilled(){return filled;}
	    public Color getColor(){return color;}
	   
	 
}
