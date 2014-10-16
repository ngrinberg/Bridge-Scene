package main;

	import util.annotations.Tags;
import interfaces.BroadcastingClearanceManager;
//import interfaces.ClearanceManager;
	@Tags({"Proceed All"})
public class ProceedAllCommand implements Runnable {
	 
		BroadcastingClearanceManager proceedAll;
		
		ProceedAllCommand(BroadcastingClearanceManager proceedingAll)
		{
			
			proceedAll=proceedingAll;
		}

		@Override
		public void run() {
			proceedAll.proceedAll();
			
		}
	}



