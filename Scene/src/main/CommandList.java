package main;

import interfaces.CommandListerface;

import java.util.List;
import java.util.ArrayList;

import util.annotations.Tags;
@Tags("Command List")
public class CommandList implements CommandListerface {
    Runnable commandz;
	List <Runnable> commandList = new ArrayList<Runnable>();
	
	public CommandList()
	{
		
		
	}
	public void addCommands(Runnable commands)
	{
		commandz=commands;
		if(commandz instanceof Runnable)
		{
			
			commandList.add(commandz);
			
		}
		
		
	}
	@Override
	public void run() {
		for(int i=0;i<commandList.size();i++)
		{
			commandList.get(i).run();
			
  
			
		}
		
		
	}

	
	
	
	
}
