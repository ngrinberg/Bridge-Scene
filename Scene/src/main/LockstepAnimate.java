package main;

import interfaces.AvatarAnimaterface;
import interfaces.Avatarface;
import interfaces.BroadcastingClearanceManager;

//import util.misc.ThreadSupport;

public class LockstepAnimate implements AvatarAnimaterface {
		Avatarface avatar;
		BroadcastingClearanceManager clear;

		public LockstepAnimate(Avatarface theAvatar,BroadcastingClearanceManager manage) {
			avatar=theAvatar;
			clear=manage;
		}

		public synchronized void animate(int newX, int newY) // takes in two integers and moves
												// the avatar of choice to the spot
		{
			int test = 0;

			int newXz = newX;
			int newYz = newY;

			while (test < 5) {
				avatar.move(newXz, newYz);
				clear.waitForProceed();
				test++;
			}

		}

}
