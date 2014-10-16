package main;

import interfaces.Avatarface;
import util.annotations.Tags;


@Tags({ "move command" })
public class MoveCommand implements Runnable {

	Avatarface poop;
	int boobz;
	int meow;

	public MoveCommand(Avatarface newPoop, int boobiez, int meowMeow) {
		poop = newPoop;
		boobz = boobiez;
		meow = meowMeow;

	}
	

	public void run() {

	poop.move(boobz, meow);

	}
}
