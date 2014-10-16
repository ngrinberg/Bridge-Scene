package main;

import interfaces.PaintListenerterface;
import interfaces.Universe;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

//import util.models.PropertyListenerRegisterer;


import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags({ "Observable Painter" })

public class ObservablePainter extends Component {

	PaintListenerterface arthurListener;
	PaintListenerterface galahadListener;
	PaintListenerterface robinListener;
	PaintListenerterface lancelotListener;
	PaintListenerterface guardListener;
	PaintListenerterface shapeListener;

	Universe aUni;

	public ObservablePainter(Universe theUniverse) {
		aUni = theUniverse;
		// creates a shape listener view object that takes in the universe
		// object and this class into its listener class
		arthurListener = new AvatarView(aUni.getArthur(), this);
		lancelotListener = new AvatarView(aUni.getLancelot(), this);
		galahadListener = new AvatarView(aUni.getGalahad(), this);
		robinListener = new AvatarView(aUni.getRobin(), this);
		guardListener = new AvatarView(aUni.getGuard(), this);
		shapeListener = new ShapeView(aUni, this);

	}

	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		// g2.setStroke(dotted);
		// g.setColor(Color.BLACK);
		// draw(g2, );

		arthurListener.paint(g2);// calls the paint of each listener
		lancelotListener.paint(g2);
		galahadListener.paint(g2);
		robinListener.paint(g2);
		guardListener.paint(g2);
		shapeListener.paint(g2);
	}

	public void register(PropertyListenerRegisterer aPropertyChangeRegister) {
		aPropertyChangeRegister.addPropertyChangeListener(arthurListener);// registers
																			// each
																			// paintlistener
																			// as
																			// a
																			// listener
																			// of
																			// this
																			// class
		aPropertyChangeRegister.addPropertyChangeListener(lancelotListener);
		aPropertyChangeRegister.addPropertyChangeListener(galahadListener);
		aPropertyChangeRegister.addPropertyChangeListener(robinListener);
		aPropertyChangeRegister.addPropertyChangeListener(guardListener);
		aPropertyChangeRegister.addPropertyChangeListener(shapeListener);
	}

}
