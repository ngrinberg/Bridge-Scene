package main;


import interfaces.Universe;
import util.annotations.Tags;
@Tags({"pass command"})

public class PassCommand implements Runnable {

Universe university;

	public PassCommand(Universe newUniversity) {
		
       university=newUniversity;
        

	}

	public void run() {

		university.passed();

	}
}


