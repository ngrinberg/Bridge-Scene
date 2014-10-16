package main;

import interfaces.Avatarface;
import interfaces.ImageShape;
import interfaces.Lineterface;
import interfaces.PaintListenerterface;
import interfaces.StringShape;


import java.awt.BasicStroke;
import java.awt.Color;
//import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
//import java.awt.image.ImageObserver;
import java.beans.PropertyChangeEvent;

import util.annotations.Tags;
@Tags({"Observing Bridge Scene Painter"})


public class AvatarView  implements PaintListenerterface{
	Avatarface aAvatar;
	ObservablePainter paintz;
	BasicStroke dotted = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 
	        5f, new float[] {2f}, 0f);// sets the ui lines to look dotted and rounded
	public AvatarView(Avatarface theAv,ObservablePainter thePaint)// takes in 
	{
		
		this.aAvatar=theAv;
		paintz=thePaint;
		
		theAv.getArms().getLeftLine().addPropertyChangeListener(this);// adds each avatar part as a property change listener
		theAv.getArms().getRightLine().addPropertyChangeListener(this);
		theAv.getLegs().getLeftLine().addPropertyChangeListener(this);
		theAv.getLegs().getRightLine().addPropertyChangeListener(this);
		theAv.getImage().addPropertyChangeListener(this);
		theAv.getTorso().addPropertyChangeListener(this);
		theAv.getTheText().addPropertyChangeListener(this);
		
		paintz.addPropertyChangeListener(this);// adds the observable painter as a prop change object as well

	}
	
    
		 
		
	    public void draw(Graphics g, StringShape aLabel) {// gets text for avatar
	        String s = aLabel.getText();
	        
	        g.drawString(s, aLabel.getX(), aLabel.getY());      
	    }
	    
  

	    public  void draw(Graphics2D g, Avatarface avatar) {// draws each part
	 
	      draw(g, avatar.getArms().getLeftLine());
	      draw(g,avatar.getArms().getRightLine());
	      draw(g,avatar.getLegs().getLeftLine());
	      draw(g,avatar.getLegs().getRightLine());
	      draw(g,avatar.getTorso());
	      draw(g, avatar.getImage());
	      draw(g, avatar.getTheText());
	     
	       // g.drawImage(img, x, y,height,width, this);     
	    }
		public void draw(Graphics g, Lineterface aline) {//draws each line
			g.drawLine(aline.getX(), aline.getY(), aline.getX() + aline.getWidth(),
					aline.getY() + aline.getHeight());
			
		}
		  public  void draw(Graphics2D g, ImageShape anImage) {//draws the head images
		    	 
		    	
		    	Image img = Toolkit.getDefaultToolkit().getImage(anImage.getImageFileName());
		         g.drawImage(img, anImage.getX(), anImage.getY(), paintz);   
		       
		    }
		
		//@Override
		public void propertyChange(PropertyChangeEvent arg0) {
		
			     
		paintz.repaint();// calls repaint in observable painter which in turn calls all of these paint listeners's paints
		}

		@Override
		public void paint(Graphics2D g) {// avatar paint method 
			  Graphics2D g2 = (Graphics2D) g;
		        g2.setStroke(dotted);
		        g.setColor(Color.BLACK);     
		        draw(g2,aAvatar );
		   
		}





	
	
}
