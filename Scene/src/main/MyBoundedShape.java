package main;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import interfaces.BoundedShapeterface;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.RECTANGLE_PATTERN)
@Tags({ "Bounded Shape" })
@PropertyNames({ "x", "y", "width", "height", "full" })
@EditablePropertyNames({ "x", "y", "width", "height" })
public abstract class MyBoundedShape extends MyLocatable implements BoundedShapeterface {

	int height, width;

	public MyBoundedShape(int initX, int initY, int initHeight, int initWidth) {// grabs
																				// initial
																				// values
																				// from
																				// driver
																				// set
																				// to
																				// 20
																				// at
																				// first
		super(initX, initY); // assigning properties values

		height = initHeight;
		width = initWidth;

	}

	public void setHeight(int newHeight) {
		int oldHeight = height;
		height = newHeight;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this,
				"height", oldHeight, newHeight));

	}

	public void setWidth(int newWidth) {
		int oldWidth = width;
		width = newWidth;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this,
				"width", oldWidth, newWidth));

	}

	public int getWidth() {
		return width;
	}// returns width

	public int getHeight() {
		return height;
	}// determines height

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.add(listener);
	}

}
