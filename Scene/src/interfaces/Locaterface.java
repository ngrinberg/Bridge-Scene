package interfaces;



import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags({"Locatable"})

public interface Locaterface extends PropertyListenerRegisterer {
	 public int getX(); //use for later
	    public void setX(int newX); 
	    public int getY() ;
	    public void setY(int newY);
	    
}
