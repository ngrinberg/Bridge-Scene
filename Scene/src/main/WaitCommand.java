package main;

import util.annotations.Tags;
import interfaces.BroadcastingClearanceManager;

@Tags({"Wait"})

public class WaitCommand implements Runnable {
 
	BroadcastingClearanceManager wait;
	
	WaitCommand(BroadcastingClearanceManager waiting)
	{
		
		wait=waiting;
	}

	@Override
	public void run() {
		wait.waitForProceed();
		
	}
}
