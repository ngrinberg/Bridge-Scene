package main;

import interfaces.Universe;
import util.annotations.Tags;

@Tags({ "say command" })
public class SayCommand implements Runnable {

	Universe butthole;
	String userInput;

	public SayCommand(Universe buttheadface, String inputUser) {
		butthole = buttheadface;
		userInput = inputUser;

	}

	public void run() {

		butthole.sayScene(userInput);

	}
}
