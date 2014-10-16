package main;

import interfaces.Angleterface;
import interfaces.Lineterface;
import util.annotations.PropertyNames;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.StructurePattern;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "rightLine", "leftLine" })
@Tags({ "Angle" })
public class AngleShape implements Angleterface {

	int x, y;
	double angle;
	int radius;
	Lineterface rightLine;
	Lineterface leftLine;

	public AngleShape(int initX, int initY, double initA, int initR) {// grabs
																		// initial
																		// values
																		// from
																		// driver
																		// set
																		// to 20
																		// at
																		// first
		x = initX;
		y = initY;
		radius = initR;
		angle = initA;

		rightLine = new Linez(x, y, angle, radius);
		leftLine = new Linez(x, y, (11 * angle) / 6, radius);// angle must be
																// 11pi/6 to
																// create and
																// angle with
																// right lines
																// pi/3

	}

	public void moveLine(int newX, int newY) {// moves the point of the angle
		x = newX;
		y = newY;
		rightLine = new Linez(x, y, angle, radius);
		leftLine = new Linez(x, y, (11 * angle) / 6, radius);
	}

	public Lineterface getRightLine() {
		return rightLine;
	} // returns lines

	public Lineterface getLeftLine() {
		return leftLine;
	}

}
