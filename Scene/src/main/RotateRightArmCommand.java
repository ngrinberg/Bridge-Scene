package main;

	import util.annotations.Tags;

	import interfaces.Avatarface;
	@Tags({"rotate right arm "})
public class RotateRightArmCommand implements Runnable {

	    int degrees;
		Avatarface avatard;

			public RotateRightArmCommand(Avatarface newAvatard, int units) {
				degrees=units;
		       avatard=newAvatard;
		      
		        

			}

			public void run() {
	           
				for(double i=avatard.getArms().getRightLine().getAngle(); i<Math.toRadians(degrees);i++)
				{
				avatard.getArms().getRightLine().rotateLine(i);
				}

			}
		}





