package main;

import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"Sleep"})

public class SleepCommand implements Runnable {

	    int time;
	

			public SleepCommand( int units) {
				time=units;
		      
		      
		        

			}

			public void run() {
	           
		ThreadSupport.sleep(time);
			}
}
