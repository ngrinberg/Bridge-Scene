package main;

import interfaces.AvatarAnimaterface;
import interfaces.Avatarface;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({ "animator" })
public class AvatarAnimate implements AvatarAnimaterface {
	Avatarface avatar;

	public AvatarAnimate(Avatarface theAvatar) {
		avatar = theAvatar;
	}

	public synchronized void animate(int newX, int newY) // takes in two integers and moves
											// the avatar of choice to the spot
	{
		int test = 0;

		int newXz = newX;
		int newYz = newY;

		while (test < 5) {
			avatar.move(newXz, newYz);
			ThreadSupport.sleep(200);
			test++;
		}

	}

}
