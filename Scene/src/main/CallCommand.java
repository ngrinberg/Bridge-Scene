package main;

import util.annotations.Tags;
import interfaces.Tableterface;
@Tags("Call")

public class CallCommand implements Runnable {

		Tableterface<String,Object> table;
		
		String name;
		CallCommand(String n, Tableterface<String,Object> t)// declares a table of type string and object
		{
			table=t;
		
			name=n;
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Runnable newRun=(Runnable) table.get(name);// casts object as runnable
			newRun.run();
			
			
		}
	}


