package interfaces;

import java.awt.Graphics2D;
import java.beans.PropertyChangeListener;


import util.annotations.Tags;

@Tags({"Paint Listener"})
public interface PaintListenerterface extends PropertyChangeListener {
	void paint (Graphics2D g);

	

	
}

	
