package main;

import interfaces.PropertyChangeMonitor;
import interfaces.Universe;

import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;

import util.annotations.Tags;

@Tags({ "Console Scene View" })
public class APropertyChangeMonitor implements PropertyChangeMonitor {
	Universe aUniverse;

	public APropertyChangeMonitor(Universe theUniverse) {
		aUniverse = theUniverse;
		theUniverse.addPropertyChangeListener(this);
		theUniverse.getArthur().getArms().getLeftLine()
				.addPropertyChangeListener(this);// adds arthur's left arm to
													// the collection
		theUniverse.getArthur().getArms().getRightLine()
				.addPropertyChangeListener(this);
		theUniverse.getArthur().getLegs().getLeftLine()
				.addPropertyChangeListener(this);
		theUniverse.getArthur().getLegs().getRightLine()
				.addPropertyChangeListener(this);
		theUniverse.getArthur().getImage().addPropertyChangeListener(this);
		theUniverse.getArthur().getTorso().addPropertyChangeListener(this);
		theUniverse.getArthur().getTheText().addPropertyChangeListener(this);

		theUniverse.getLancelot().getArms().getLeftLine()
				.addPropertyChangeListener(this);
		theUniverse.getLancelot().getArms().getRightLine()
				.addPropertyChangeListener(this);
		theUniverse.getLancelot().getLegs().getLeftLine()
				.addPropertyChangeListener(this);
		theUniverse.getLancelot().getLegs().getRightLine()
				.addPropertyChangeListener(this);
		theUniverse.getLancelot().getImage().addPropertyChangeListener(this);
		theUniverse.getLancelot().getTorso().addPropertyChangeListener(this);
		theUniverse.getLancelot().getTheText().addPropertyChangeListener(this);

		theUniverse.getGalahad().getArms().getLeftLine()
				.addPropertyChangeListener(this);
		theUniverse.getGalahad().getArms().getRightLine()
				.addPropertyChangeListener(this);
		theUniverse.getGalahad().getLegs().getLeftLine()
				.addPropertyChangeListener(this);
		theUniverse.getGalahad().getLegs().getRightLine()
				.addPropertyChangeListener(this);
		theUniverse.getGalahad().getImage().addPropertyChangeListener(this);
		theUniverse.getGalahad().getTorso().addPropertyChangeListener(this);
		theUniverse.getGalahad().getTheText().addPropertyChangeListener(this);

		theUniverse.getRobin().getArms().getLeftLine()
				.addPropertyChangeListener(this);
		theUniverse.getRobin().getArms().getRightLine()
				.addPropertyChangeListener(this);
		theUniverse.getRobin().getLegs().getLeftLine()
				.addPropertyChangeListener(this);
		theUniverse.getRobin().getLegs().getRightLine()
				.addPropertyChangeListener(this);
		theUniverse.getRobin().getImage().addPropertyChangeListener(this);
		theUniverse.getRobin().getTorso().addPropertyChangeListener(this);
		theUniverse.getRobin().getTheText().addPropertyChangeListener(this);

		theUniverse.getGuard().getArms().getLeftLine()
				.addPropertyChangeListener(this);
		theUniverse.getGuard().getArms().getRightLine()
				.addPropertyChangeListener(this);
		theUniverse.getGuard().getLegs().getLeftLine()
				.addPropertyChangeListener(this);
		theUniverse.getGuard().getLegs().getRightLine()
				.addPropertyChangeListener(this);
		theUniverse.getGuard().getImage().addPropertyChangeListener(this);
		theUniverse.getGuard().getTorso().addPropertyChangeListener(this);
		theUniverse.getGuard().getTheText().addPropertyChangeListener(this);

	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		String current = "";
		if (arg0.getSource() == aUniverse.getArthur().getArms().getLeftLine())// identifies
																				// who's
																				// arm
																				// it
																				// is
																				// based
																				// on
																				// the
																				// input
			current = "Arthur's Left Arm";
		else if (arg0.getSource() == aUniverse.getArthur().getArms()
				.getRightLine())
			current = "Arthur's Right Arm";
		else if (arg0.getSource() == aUniverse.getArthur().getLegs()
				.getLeftLine())
			current = "Arthur's Left Leg";
		else if (arg0.getSource() == aUniverse.getArthur().getLegs()
				.getRightLine())
			current = "Arthur's Right Leg";
		else if (arg0.getSource() == aUniverse.getArthur().getImage())
			current = "Arthur's Head";
		else if (arg0.getSource() == aUniverse.getArthur().getTorso())
			current = "Arthur's Torso";
		else if (arg0.getSource() == aUniverse.getArthur().getTheText())
			current = "Arthur's Text";

		//
		else if (arg0.getSource() == aUniverse.getGalahad().getArms()
				.getLeftLine())
			current = "Galahad's Left Arm";
		else if (arg0.getSource() == aUniverse.getGalahad().getArms()
				.getRightLine())
			current = "Galahad's Right Arm";
		else if (arg0.getSource() == aUniverse.getGalahad().getLegs()
				.getLeftLine())
			current = "Galahad's Left Leg";
		else if (arg0.getSource() == aUniverse.getGalahad().getLegs()
				.getRightLine())
			current = "Galahad's Right Leg";
		else if (arg0.getSource() == aUniverse.getGalahad().getImage())
			current = "Galahad's Head";
		else if (arg0.getSource() == aUniverse.getGalahad().getTorso())
			current = "Galahad's Torso";
		else if (arg0.getSource() == aUniverse.getGalahad().getTheText())
			current = "Galahad's Text";

		//
		else if (arg0.getSource() == aUniverse.getLancelot().getArms()
				.getLeftLine())
			current = "Lancelot's Left Arm";
		else if (arg0.getSource() == aUniverse.getLancelot().getArms()
				.getRightLine())
			current = "Lancelot's Right Arm";
		else if (arg0.getSource() == aUniverse.getLancelot().getLegs()
				.getLeftLine())
			current = "Lancelot's Left Leg";
		else if (arg0.getSource() == aUniverse.getLancelot().getLegs()
				.getRightLine())
			current = "Lancelot's Right Leg";
		else if (arg0.getSource() == aUniverse.getLancelot().getImage())
			current = "Lancelot's Head";
		else if (arg0.getSource() == aUniverse.getLancelot().getTorso())
			current = "Lancelot's Torso";
		else if (arg0.getSource() == aUniverse.getLancelot().getTheText())
			current = "Lancelot's Text";

		//
		else if (arg0.getSource() == aUniverse.getRobin().getArms()
				.getLeftLine())
			current = "Robin's Left Arm";
		else if (arg0.getSource() == aUniverse.getRobin().getArms()
				.getRightLine())
			current = "Robin's Right Arm";
		else if (arg0.getSource() == aUniverse.getRobin().getLegs()
				.getLeftLine())
			current = "Robin's Left Leg";
		else if (arg0.getSource() == aUniverse.getRobin().getLegs()
				.getRightLine())
			current = "Robin's Right Leg";
		else if (arg0.getSource() == aUniverse.getRobin().getImage())
			current = "Robin's Head";
		else if (arg0.getSource() == aUniverse.getRobin().getTorso())
			current = "Robin's Torso";
		else if (arg0.getSource() == aUniverse.getRobin().getTheText())
			current = "Robin's Text";

		//
		else if (arg0.getSource() == aUniverse.getGuard().getArms()
				.getLeftLine())
			current = "Guard's Left Arm";
		else if (arg0.getSource() == aUniverse.getGuard().getArms()
				.getRightLine())
			current = "Guard's Right Arm";
		else if (arg0.getSource() == aUniverse.getGuard().getLegs()
				.getLeftLine())
			current = "Guard's Left Leg";
		else if (arg0.getSource() == aUniverse.getGuard().getLegs()
				.getRightLine())
			current = "Guard's Right Leg";
		else if (arg0.getSource() == aUniverse.getGuard().getImage())
			current = "Guard's Head";
		else if (arg0.getSource() == aUniverse.getGuard().getTorso())
			current = "Guard's Torso";
		else if (arg0.getSource() == aUniverse.getGuard().getTheText())
			current = "Guard's Text";

		System.out.println("Object: "
				+ current
				+ "\t Property name: "// prints out notifier information
				+ arg0.getPropertyName() + "\t old value: "
				+ arg0.getOldValue() + "\t new value: " + arg0.getNewValue()
				+ arg0.getSource());
		System.out.println();
	}

}
