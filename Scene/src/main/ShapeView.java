package main;

import interfaces.Ovalterface;
import interfaces.PaintListenerterface;
import interfaces.Universe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;

import util.annotations.Tags;

@Tags({ "Observing Bridge Scene Painter" })
public class ShapeView implements PaintListenerterface {

	Universe aUni;
	// BridgeShape bridge;
	// Oval ovalz;

	ObservablePainter paintz;
	BasicStroke dotted = new BasicStroke(5f, BasicStroke.CAP_ROUND,
			BasicStroke.JOIN_ROUND, 5f, new float[] { 2f }, 0f);

	public ShapeView(Universe theUniverse, ObservablePainter observeShapes) {
		this.aUni = theUniverse;
		this.paintz = observeShapes;

		paintz.addPropertyChangeListener(this);

	}

	public void draw(Graphics2D g, Universe scene) {// gets all shapes in the
													// scene

		draw(g, scene.getGuardOval());// adds arthur's left arm to the
										// collection
		draw(g, scene.getOtherOval());
		draw(g, scene.getBridgeShape());
		draw(g, scene.getBridgeShape2());
		draw(g, scene.getBridgeShape3());
		draw(g, scene.getGorge());
	}

	public void draw(Graphics g, Ovalterface shapes)// type ovalterface
	{

		int x = shapes.getX();// gets x,y height and width
		int y = shapes.getY();
		int width = shapes.getWidth();
		int height = shapes.getHeight();

		g.drawRect(x, y, width,// draws shaes
				height);
	}

	public void draw(Graphics g, BridgeShape bridgeS)// specific bride shape
	{

		int x = bridgeS.getX();
		int y = bridgeS.getY();
		int width = bridgeS.getWidth();
		int height = bridgeS.getHeight();

		g.drawRect(x, y, width, height);
	}

	public void draw(Graphics g, Oval oval)// specific oval
	{
		int x = oval.getX();
		int y = oval.getY();
		int width = oval.getWidth();
		int height = oval.getHeight();

		g.drawOval(x, y, width, height);
	}

	public void propertyChange(PropertyChangeEvent arg0) {

		paintz.repaint();// calls repaint when a propterty change event occurs
	}

	@Override
	public void paint(Graphics2D g) { // which indirectly calls this paint
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(dotted);
		g.setColor(Color.BLUE);
		draw(g2, aUni);

	}

}
