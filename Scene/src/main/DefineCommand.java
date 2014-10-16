package main;

import util.annotations.Tags;
import interfaces.Tableterface;

@Tags({"Define"})
public class DefineCommand implements Runnable {

	Tableterface<String,Object> table;
	Runnable command;
	String name;
	DefineCommand(String n, Runnable c, Tableterface<String,Object> t)
	{
		table=t;
		command=c;
		name=n;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		table.put(name, (Object) command);
		
	}
}
