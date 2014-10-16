package interfaces;

import util.models.PropertyListenerRegisterer;

//import main.Point;

public interface Universe extends PropertyListenerRegisterer {

	public Avatarface getArthur();

	public Avatarface getGalahad();

	public Avatarface getLancelot();

	public Avatarface getRobin();

	public Avatarface getGuard();

	// public boolean getOccupado();
	// public boolean getTurn();
	public void approach(Avatarface newAvatar);

	public void sayScene(String convo);

	public void passed();

	public void failed();

	public boolean preGetApproach();

	public boolean preSayScene();

	public boolean prePassed();

	public boolean preFailed();

	public Ovalterface getGuardOval();

	public Ovalterface getOtherOval();

	public Ovalterface getBridgeShape();

	public Ovalterface getBridgeShape2();

	public Ovalterface getBridgeShape3();

	public Ovalterface getGorge();

}
