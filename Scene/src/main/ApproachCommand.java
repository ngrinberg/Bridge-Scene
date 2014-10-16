package main;


import interfaces.Avatarface;
import interfaces.Universe;
import util.annotations.Tags;
@Tags({"approach command"})

public class ApproachCommand implements Runnable {

Universe university;
Avatarface avatard;

	public ApproachCommand(Universe newUniversity,Avatarface newAvatard) {
		
       avatard=newAvatard;
       university=newUniversity;
        

	}

	public void run() {

		university.approach(avatard);

	}
}

