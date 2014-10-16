package main;

import interfaces.Avatarface;
import interfaces.BroadcastingClearanceManager;

import interfaces.GuardAnimaterface;
import util.misc.ThreadSupport;

public class LockstepGuard implements GuardAnimaterface {
		Avatarface avatar;
		BroadcastingClearanceManager clear;

		public LockstepGuard(Avatarface theAvatar,BroadcastingClearanceManager clearest) {
			avatar = theAvatar;
			clear=clearest;

		}

		public synchronized void animate(int anAnimationPauseTime) // takes in a pause time
		{
			boolean clap = true;
			int test = 0;
			;
			while (test < 6)// does this 10 times
			{
				if (clap == true)// alternates between clapping and unclapping
				{

					avatar.getArms().getLeftLine().setAngle(Math.toRadians(90));

					avatar.getArms().getRightLine().setAngle(Math.toRadians(90));

					clap = false;

				} else {
					avatar.getArms().getLeftLine().setAngle(11 * Math.PI / 18);// moves
																				// back
																				// to
																				// original
																				// angles

					avatar.getArms().getRightLine().setAngle(Math.toRadians(60));

					clap = true;
				}
				ThreadSupport.sleep(anAnimationPauseTime);
               clear.proceedAll();
				test++;
			}
		
		}}
