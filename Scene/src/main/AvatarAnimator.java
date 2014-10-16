package main;

import util.annotations.Tags;

import interfaces.AvatarAnimaterface;


@Tags({ "animating command" })
public class AvatarAnimator implements Runnable {

	AvatarAnimaterface animator;
	int side;
	int down;

	public AvatarAnimator(AvatarAnimaterface ani, int x, int y) {// takes in
																	// instance
											// animating/animator
																	// class and
																	// two
																	// integers
		animator = ani;
		side = x;
		down = y;
	}

	public void run() {
		
		// run metthod of runnable executes animate method.
		animator.animate(side, down);
	}
}
