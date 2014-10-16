package main;

import util.annotations.StructurePattern;
import interfaces.StringShape;

import java.awt.Color;
import java.beans.PropertyChangeEvent;

import util.annotations.PropertyNames;
import util.annotations.EditablePropertyNames;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
@PropertyNames({ "text", "x", "y", "color" })
@EditablePropertyNames({ "x", "y", "text" })
public class AStringShape extends MyLocatable implements StringShape {
	String text;

	public AStringShape(String initText, int initX, int initY) {
		super(initX, initY);
		text = initText;

	}

	public Color getColor() {
		return Color.BLACK;
	}

	public String getText() {
		return text;
	}

	public void setText(String newVal) {
		String oldVal = text;
		text = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this,
				"Text", oldVal, newVal));
	}

}
