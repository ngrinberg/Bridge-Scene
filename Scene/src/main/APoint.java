package main;

import interfaces.Point;
import util.annotations.EditablePropertyNames;
import util.annotations.Explanation;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.POINT_PATTERN)
@Explanation("Uses Cartesian representation.")
@PropertyNames({ "x", "y" })
@EditablePropertyNames({ "x", "y" })
public class APoint extends MyLocatable implements Point {

	public APoint(int theX, int theY) {
		super(theX, theY);
	}

}
