	package main;

	import util.annotations.Tags;

import interfaces.GuardAnimaterface;
	@Tags({"animating command"})

public class GuardAnimator implements Runnable {// runnable for guard

		GuardAnimaterface animator;
		int pause;
		

		public GuardAnimator(GuardAnimaterface ani,int pauseTime) {
			animator = ani;
		pause=pauseTime;
		}

		public void run() {//excecutes guard animate
			animator.animate(pause);
		}
	}


