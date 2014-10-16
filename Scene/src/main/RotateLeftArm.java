package main;

import util.annotations.Tags;
import interfaces.Avatarface;

@Tags({"rotate left arm"})
public class RotateLeftArm  implements Runnable {

    int degrees;
	Avatarface avatard;

		public RotateLeftArm(Avatarface newAvatard, int units) {
			degrees=units;
	       avatard=newAvatard;
	      
	        

		}

		public void run() {
           
			for(double i=avatard.getArms().getLeftLine().getAngle(); i<Math.toRadians(degrees);i++)
			{
			avatard.getArms().getLeftLine().rotateLine(i);
			}

		}
	}



