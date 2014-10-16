package main;

import java.beans.PropertyChangeListener;

import interfaces.Angleterface;
import interfaces.Avatarface;
import interfaces.ImageShape;
import interfaces.Lineterface;
import interfaces.Point;
import interfaces.StringShape;
import shapes.Locatable;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({ "Avatar" })
public class Avatar extends MyLocatable implements Avatarface {

	StringShape theText;// string shape
	int x, y;

	Point lineLocation;
	Angleterface arms;
	Angleterface legs;
	Lineterface torso;
	ImageShape image;
	Locatable avatar;

	public Avatar(String imageName, String shape, int initX, int initY,
			double angle, int radius, int height, int width) {
		super(initX, initY);

		theText = new AStringShape(shape, getX() + width, getY());// positioned
																	// right
																	// next to
																	// the head
		arms = new AngleShape(getX() + width / 3, getY() + height, angle,
				radius);
		torso = new Linez(getX() + (width / 3), getY() + height,
				3 * (angle) / 2, radius);
		legs = new AngleShape(getX() + (width / 3), (getY() + height) + radius,
				angle, radius);// y+radius was necessary to have the legs at the
								// end of the torso
		image = new AShapeImage(imageName, getX(), getY(), height, width);

	}

	@Tags({ "connect" })
	public void connect() {
		// connects all parts at points
		theText.setY(getY());
		theText.setX(getX() + image.getWidth());
		// lineLocation.setX(getX());
		// lineLocation.setY(getY());
		// theText = new AStringShape(shape,x+width,y);// positioned right next
		// to the head
		// lineLocation=new APoint(x,y);
		arms.getLeftLine().setX(getX() + image.getWidth() / 3);
		arms.getRightLine().setX(getX() + image.getWidth() / 3);
		arms.getLeftLine().setY(getY() + image.getHeight());

		arms.getRightLine().setY(getY() + image.getHeight());
		// arms=new AngleShape(x+width/3,y+height,angle,radius);
		torso.setX(getX() + image.getWidth() / 3);
		torso.setY(getY() + image.getHeight());
		// y+height,3*(angle)/2,radius);
		legs.getLeftLine().setX(getX() + image.getWidth() / 3);
		legs.getLeftLine().setY(
				getY() + image.getHeight() + (int) torso.getRadius());
		legs.getRightLine().setX(getX() + image.getWidth() / 3);
		legs.getRightLine().setY(getY() + image.getWidth() / 3);
		legs.getRightLine().setY(
				getY() + image.getHeight() + (int) torso.getRadius());
		// legs=new AngleShape(x+(width/3),(y+height)+radius,(angle),radius);//
		// y+radius was necessary to have the legs at the end of the torso
		image.setX(getX());
		image.setY(getY());
	};

	@Tags({ "move" })
	public void move(int newX, int newY) {// moves the avatar as a whole to
											// another point x and y
		setX(getX() + newX);
		setY(getY() + newY);

		connect();

	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.add(listener);
	}

	public StringShape getTheText() {
		return theText;
	}// returns properties

	public ImageShape getImage() {
		return image;
	}

	public Angleterface getArms() {
		return arms;
	}

	public Angleterface getLegs() {
		return legs;
	}

	public Lineterface getTorso() {
		return torso;
	}

	@Visible(false)
	public Point getLineLocation() {
		return lineLocation;
	}

	// @Visible(false)

}