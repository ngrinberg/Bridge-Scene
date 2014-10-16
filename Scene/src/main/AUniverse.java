package main;

import java.awt.Color;
import java.beans.PropertyChangeEvent;

//import bus.uigen.ObjectEditor;
import interfaces.Avatarface;

import interfaces.Ovalterface;
import interfaces.Universe;
import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.PropertyNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "arthur", "galahad", "lancelot", "robin", "guard", "occupado", "turn", "BridgeShape", "BridgeShape2",
		"BridgeShape3", "GuardOval", "OtherOval", "Gorge" })
@EditablePropertyNames({"x", "y" })
// text/knight isn't really a property but if i take away text or rearrange this
// in anyway everything will be behind the shapes.
@Tags({ "Bridge Scene" })
// import util.annotations.Visible;
public class AUniverse extends MyLocatable implements Universe {

	Avatarface arthur;
	Avatarface galahad;
	Avatarface lancelot;
	Avatarface robin;
	Avatarface guard;
	String text;
	Avatarface knight;
	boolean occupado;
	boolean turn;
	Ovalterface guardOval;
	Ovalterface otherOval;
	Ovalterface bridgeShape;
	Ovalterface bridgeShape2;
	Ovalterface bridgeShape3;
	Ovalterface gorge;

	// import object editor declare as global variable for use in methods

	public AUniverse() {
		super(0, 0);
		arthur = new Avatar("arthur.jpg", "", 40, 20, Math.PI / 3, 50, 50, 50);// parameters
																				// are
																				// name
																				// of
																				// image,string
																				// shape,x,y,angle,radius,height,width
																				// of
																				// image
		galahad = new Avatar("galahad.jpg", "", 200, 40, Math.PI / 3, 50, 50,
				50);
		lancelot = new Avatar("lancelot.jpg", "", 400, 110, Math.PI / 3, 50,
				50, 50);
		robin = new Avatar("robin.jpg", "", 100, 300, Math.PI / 3, 50, 50, 50);
		guard = new Avatar("guard.jpg", "", 800, 400, Math.PI / 3, 50, 50, 50);
		occupado = false;
		turn = false;

		text = "";

		guardOval = new Oval(798, 525, 50, 50, Color.GRAY);// x,y,height,width,color
		otherOval = new Oval(700, 500, 50, 50, Color.GRAY);
		bridgeShape = new BridgeShape(890, 540, 100, 400, Color.YELLOW);
		bridgeShape2 = new BridgeShape(890, 530, 10, 400, Color.YELLOW);
		bridgeShape3 = new BridgeShape(890, 640, 10, 400, Color.YELLOW);
		gorge = new BridgeShape(890, 0, 1000, 400, Color.CYAN);
		// create object editor in constructor

	}

	public boolean preGetApproach() {
		return occupado == false;
	}

	@Tags({ "Approach" })
	public void approach(Avatarface newAvatar) {
		assert preGetApproach();
		knight = newAvatar;// sets parameter to global variable knight
		if (occupado == false)// if circle isnt occupied
		{ // 400,110
			if (knight == lancelot)// if the knight passed in is lancelot
			{
				for (int i = 0; i < 30; i++) {
					knight.move(10, 9);// move it a certain amount to the circle

				}

			} else if (knight == robin) {
				// 100,300
				for (int i = 0; i < 20; i++) {
					knight.move(30, 4);

				}

			} else if (knight == galahad) {
				// 200,40

				for (int i = 0; i < 83; i++) {
					knight.move(6, 4);

				}

			} else if (knight == arthur) {// ,40,20
				for (int i = 0; i < 20; i++) {
					knight.move(33, 18);

				}
			}

			occupado = true;// and now the circle is occupied
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this,
					"occupado", preGetApproach(), true));
		}

	}

	public boolean preSayScene() {
		return occupado == true;

	}

	public void sayScene(String convo) {
		assert preSayScene();
		text = convo;

		if (occupado == true)// if the circle is occupied
		{
			if (turn == false)// if its the guards turn to speak
			{
				guard.getTheText().setText(text);// then set the text to what is
													// passsed in
				turn = true;// alternate each time method is called
				propertySupport.notifyAllListeners(new PropertyChangeEvent(
						this, "turn", "sayScene", true));
			} else

			if (turn == true)// if its the knights turn to speak
			{
				knight.getTheText().setText(text);// set text to what is passed
													// in to string shape for
													// the knight

				turn = false;// alternate
				propertySupport.notifyAllListeners(new PropertyChangeEvent(
						this, "turn", "sayscene", preSayScene()));

			}

		}

	}

	public boolean prePassed() {

		return occupado == true && turn == false;

	}

	@Tags({ "Passed" })
	public void passed() {
		assert prePassed();
		if (occupado == true && turn == false)// if the circle is occupied and
												// its the guard turn to speak
												// at the end
		{
			for (int i = 0; i < 60; i++) {
				knight.move(10, 0);// move the knight across the bridge

			}
			occupado = false;
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this,
					"occupado", "passed", false));
			turn = true;

			propertySupport.notifyAllListeners(new PropertyChangeEvent(this,
					"turn", "passed", true));
		}
	}

	public boolean preFailed() {

		return occupado == true;
	}

	@Tags({ "Failed" })
	public void failed() {
		assert preFailed();
		if (occupado == true && turn == false)// if the circle is occupied and
												// its the guards turn to speak
		{
			for (int i = 0; i < 40; i++) {
				knight.move(5, -5);// move the knight into the gorge

			}
			for (int j = 50; j > 10; j--)// make the knight fall in gorge by
											// making him shrink away
			{
				// knight.scale(j, j, j);

			}
			occupado = false;
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this,
					"occupado", "failed", preFailed()));
		} else if (occupado == true && turn == true)// ditto but for guard to
													// fall in
		{
			for (int i = 0; i < 40; i++) {
				guard.move(5, -5);

			}
			// for (int j = 50; j > 10; j--) {
			// guard.scale(j, j, j);

			// }
		}

	}

	public Avatarface getArthur() {
		return arthur;
	}// returns avatars

	public Avatarface getGalahad() {
		return galahad;
	}

	public Avatarface getLancelot() {
		return lancelot;
	}

	public Avatarface getRobin() {
		return robin;
	}

	public Avatarface getGuard() {
		return guard;
	}

	public boolean getOccupado() {
		return occupado;
	}

	public boolean getTurn() {
		return turn;
	}

	public Ovalterface getGuardOval() {
		return guardOval;
	}

	public Ovalterface getOtherOval() {
		return otherOval;
	}

	public Ovalterface getBridgeShape() {
		return bridgeShape;
	}

	public Ovalterface getBridgeShape2() {
		return bridgeShape2;
	}

	public Ovalterface getBridgeShape3() {
		return bridgeShape3;
	}

	public Ovalterface getGorge() {
		return gorge;
	}

}