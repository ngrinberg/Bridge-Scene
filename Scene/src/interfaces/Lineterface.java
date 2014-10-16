package interfaces;

public interface Lineterface extends Locaterface {

	    public void setAngle(double newAngle);
		public int getWidth(); // determines width of line from the cos of the angle of the line 
		public int getHeight();
		public void rotateLine(double units);
		public double getRadius();
		public double getAngle();
}
