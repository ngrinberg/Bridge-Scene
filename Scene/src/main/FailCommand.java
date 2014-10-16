package main;


import interfaces.Universe;
import util.annotations.Tags;
@Tags({"fail command"})

public class FailCommand implements Runnable {

Universe university;

	public FailCommand(Universe newUniversity) {
		
       university=newUniversity;
        

	}

	public void run() {

		university.failed();

	}
}

