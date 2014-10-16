package interfaces;



//import java.beans.PropertyChangeListener;

import interfaces.ImageShape;

//import main.Point;

public interface Avatarface extends Locaterface  {
    public void connect();
    public void move(int newX, int newY);
	public StringShape getTheText();	
	public ImageShape getImage();
	public Angleterface getArms();
	public Angleterface getLegs();
	public Lineterface getTorso();
	public Point getLineLocation();
	
	
	
}
