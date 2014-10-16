package main;

import java.beans.PropertyChangeEvent;

import interfaces.Lineterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({ "x", "y", "radius", "angle", "width", "height" })
@EditablePropertyNames({ "x", "y", "radius", "angle" })
public class Linez extends MyLocatable implements Lineterface {

	double angle, radius;

	public Linez(int initX, int initY, double initAngle, int initRadius) {// grabs
																			// initial
																			// values
																			// from
																			// driver
																			// set
																			// to
																			// 20
																			// at
																			// first
		super(initX, initY);
		angle = initAngle;
		radius = initRadius;
	}

	public void setRadius(double newRadius) {
		double oldRadius = radius;
		radius = newRadius;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this,// notifys
																		// the
																		// radius
																		// change
				"Radius", oldRadius, newRadius));
	}

	// set radius to new value
	public void setAngle(double newAngle) {
		double oldAngle = angle;
		angle = newAngle;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this,// notifys
																		// the
																		// angle
																		// change
				"Angle", oldAngle, newAngle));

	}// sets angle to new value determined in the driver

	public double getRadius() {
		return radius;
	}

	public double getAngle() {
		return angle;
	}

	public int getWidth() {
		return (int) (radius * Math.cos(angle));
	}// determines width of line from the cos of the angle of the line

	public int getHeight() {
		return (int) (radius * Math.sin(angle));
	}// determines height of line from the sin of the angle

	@Tags({ "rotate" })
	public void rotateLine(double units) {// takes in parameters as units is
											// called from driver

		setAngle(units * Math.PI / 3);//
		//
	}
}
