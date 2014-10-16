package main;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import interfaces.BroadcastingClearanceManager;

import interfaces.Controllerterface;
import interfaces.Interpreterface;
import interfaces.PropertyChangeMonitor;
import interfaces.Scannerterface;
//import interfaces.Scannerterface;
//import interfaces.Tableterface;
import interfaces.Universe;

public class Assignment11 {

	public static void main(String[] args) {// main method

		Universe bridge = new AUniverse();

		ObservablePainter paint = new ObservablePainter(bridge);// object of
																// observabe
																// painter

		Scannerterface bean = new Scannerz();

		JFrame frame = new JFrame("A Scene View");// making two frames one for
													// the commands and one for
		JTextField texty = new JTextField();// the animation
		JTextField textSay = new JTextField();
		JFrame frame2 = new JFrame("Command Controller");
		JFrame frame3 = new JFrame("Approach");
		JFrame frame4 = new JFrame("Say");
		JFrame frame5 = new JFrame("Pass");
		JFrame frame6 = new JFrame("Fail");
		frame.add((Component) paint);// adds observable painter object
		frame.setSize(1000, 700);
		frame.setVisible(true);

		JButton button = new JButton("go");
		JButton approachButton = new JButton("go");
		JButton sayButton = new JButton("go");
		JButton passButton = new JButton("go");
		JButton failButton = new JButton("go");

		frame2.setLayout(new GridLayout(2, 1));
		frame2.add(texty);
		frame2.add(button);
		frame2.setSize(300, 100);
		frame2.setVisible(true);
		frame2.setLocation(300, 450);

		frame3.setLayout(new GridLayout(2, 1));

		frame3.add(approachButton);
		frame3.setSize(300, 100);
		frame3.setVisible(true);
		frame3.setLocation(300, 450);

		frame4.setLayout(new GridLayout(2, 1));
		frame4.add(textSay);
		frame4.add(sayButton);
		frame4.setSize(300, 100);
		frame4.setVisible(true);
		frame4.setLocation(300, 450);

		frame5.setLayout(new GridLayout(2, 1));

		frame5.add(passButton);
		frame5.setSize(300, 100);
		frame5.setVisible(true);
		frame5.setLocation(300, 450);

		frame6.setLayout(new GridLayout(2, 1));

		frame6.add(failButton);
		frame6.setSize(300, 100);
		frame6.setVisible(true);
		frame6.setLocation(300, 450);
        BroadcastingClearanceManager clear=new ABroadcastingClearanceManager();
        OEFrame editing=ObjectEditor.edit(clear);
       
		Interpreterface newp = new CommandInterpreter(bridge, bean,clear);
		
		Controllerterface newInterpret = new CommandController(texty, newp,
				button, approachButton, sayButton, passButton, failButton,
				bridge, textSay);// it works just try it!
		PropertyChangeMonitor theMonitor = new APropertyChangeMonitor(bridge);
		
		OEFrame editer=ObjectEditor.edit(newp);//not sure why this is necessary but in the directions
		sleep(3000);
		OEFrame editz = ObjectEditor.edit(bridge);
		

		// takes the scene and passes into property chnage monitor
		// creates an object editor instance calls .edit() and sends the object
		// scan
		editz.setLocation(0, 0);

		editz.setSize(400, 600);

		editz.hideMainPanel();

		sleep(2000);

		// creates an object editor instance calls .edit() and sends the object
		// bridge
/*
		bridge.approach(bridge.getArthur());// moves arthur to oval
		sleep(1000);

		bridge.sayScene("whats up");// sets text
		sleep(1000);
		bridge.sayScene("nothing");// sets text
		sleep(1000);
		bridge.passed();
		sleep(1000);
		*/

		// rotates each rotatable part
	/*	for (double i = bridge.getArthur().getArms().getLeftLine().getAngle(); i < Math
				.toRadians(550); i++)// radians needed to come full cicle
		{
			bridge.getArthur().getArms().getLeftLine().rotateLine((int) i);
			sleep(100);
		}

		sleep(1000);
		for (double i = bridge.getArthur().getArms().getRightLine().getAngle(); i < Math
				.toRadians(420); i++) {
			bridge.getArthur().getArms().getRightLine().rotateLine((int) i);
			sleep(100);
		}
		sleep(1000);

		for (double i = bridge.getArthur().getLegs().getLeftLine().getAngle(); i < Math
				.toRadians(550); i++) {
			bridge.getArthur().getLegs().getLeftLine().rotateLine((int) i);
			sleep(100);
		}
		sleep(1000);
		for (double i = bridge.getArthur().getLegs().getRightLine().getAngle(); i < Math
				.toRadians(420); i++) {
			bridge.getArthur().getLegs().getRightLine().rotateLine((int) i);
			sleep(100);
		}
		sleep(100);
		*/
		// here are some test cases you can also use my ui 
		newp.animateLancelot();// demostrates synchronized/asynchronized
		newp.animateGalahad();
		newp.animateGalahad();
		clear.waitForProceed();
		newp.setEnteredCommand("{ approach arthur  say \"name?\" say \"arthur\" }");//regular grammar
		clear.waitForProceed();
		newp.setEnteredCommand("pass");
		clear.waitForProceed();
		newp.setEnteredCommand("repeat 4 repeat 5 { move lancelot 2 2 move robin 5 5 }");
		clear.waitForProceed();
		newp.setEnteredCommand("define guardArmsIn { rotateleftarm guard 30 rotaterightarm guard 60 }");//extended grammar
		clear.waitForProceed();
		newp.setEnteredCommand("define guardArmsOut { rotateleftarm guard 300 rotaterightarm guard 600 }");
		clear.waitForProceed();
		newp.setEnteredCommand("define beat { call guardArmsIn wait sleep 100 proceedAll call guardArmsOut sleep 100 }");
		clear.waitForProceed();
		newp.setEnteredCommand("define beats repeat 5 call beat");
		clear.waitForProceed();
		newp.setEnteredCommand("call beats");
		
		clear.waitForProceed();
		newp.LockstepArthur();//demonstrates my lockstep methods make everyone move while guard claps
		newp.LockstepGalahad();
		newp.LockstepLancelot();
		newp.LockstepRobin();
		newp.LockstepGuard();
       
sleep(5000);
		newp.waitArthur();//demonstrates waitfor proceed animiations
		newp.waitGalahad();
		newp.waitLancelot();
		newp.waitRobin();
	
	
	
	
		// clapping
		

	}

	// sleep with an exception if something goes wrong

	public static void sleep(long interval) {
		try {
			Thread.sleep(interval);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
