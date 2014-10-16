package main;

import util.annotations.Tags;
import interfaces.Avatarface;
import interfaces.BroadcastingClearanceManager;
@Tags({"Wait"})

public class WaitingAnimate extends AvatarAnimate {
		Avatarface avatar;
		BroadcastingClearanceManager aManage;

		public WaitingAnimate(Avatarface theAvatar,BroadcastingClearanceManager theManage) {
			
			super(theAvatar);
			aManage=theManage;
		}
@Override
		public synchronized void animate(int newX, int newY) // takes in two integers and moves
												// the avatar of choice to the spot
		{
			aManage.waitForProceed();
			super.animate(newX, newY);
			}

		

	
}
