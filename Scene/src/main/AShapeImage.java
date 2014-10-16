package main;

import java.beans.PropertyChangeEvent;

import interfaces.ImageShape;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({ "imageFileName", "x", "y", "height", "width" })
@EditablePropertyNames({ "x", "y", "imageFileName", "height", "width" })
public class AShapeImage extends MyBoundedShape implements ImageShape {
	String imageFileName;

	public AShapeImage(String initImageFileName, int initX, int initY,
			int initHeight, int initWidth) { // sets imagename point on the oe,
												// height and width/
		super(initX, initY, initHeight, initWidth);
		imageFileName = initImageFileName;

	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String newImage) {
		String oldFileName = imageFileName;

		imageFileName = newImage;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this,
				"ImageFileName", oldFileName, newImage));
	}

}
