package main;

import util.annotations.Tags;

@Tags({"Repeat"})
public class RepeatCommand implements Runnable {
	int count;
	Runnable command;
	RepeatCommand(int counter,Runnable commandz)
	{
		command=commandz;
		count=counter;
		
	}
	public void run()
	{
		int test=0;
		while(test<count)
		{
			
			command.run();
			test++;
			
		}
		
	}

}
