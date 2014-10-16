package main;

import interfaces.Controllerterface;
import interfaces.Interpreterface;
import interfaces.Universe;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

public class CommandController implements Controllerterface {

	Interpreterface aCommand;
	JTextField entered;
	JTextField sayThis;
	JButton button;
	JButton approachButton;
	JButton sayButton;
	JButton passButton;
	JButton failButton;
	Universe scene;

	public CommandController(JTextField newEntered, Interpreterface theCommand,
			JButton newButton, JButton approach, JButton say, JButton pass,
			JButton fail, Universe uni, JTextField sayz) {
		scene = uni;
		entered = newEntered;
		sayThis = sayz;// seperate text fied for say
		// button2=newerButton;
		aCommand = theCommand;
		button = newButton;
		approachButton = approach;
		sayButton = say;
		passButton = pass;
		failButton = fail;
		button.addActionListener(this);// add all buttons as action listener
		approachButton.addActionListener(this);
		sayButton.addActionListener(this);
		passButton.addActionListener(this);
		failButton.addActionListener(this);

	}

	public void setModel(Interpreterface newCommand) {
		aCommand = newCommand;
	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == button)// differentiate between buttons performs
										// different actions
		{
			aCommand.setEnteredCommand(entered.getText());
		} else if (arg0.getSource() == approachButton) {
			if (scene.preGetApproach()) {
				scene.approach(scene.getLancelot());
			} else {
				approachButton.setEnabled(false);
			}
		} else if (arg0.getSource() == sayButton) {
			if (scene.preSayScene()) {

				scene.sayScene(sayThis.getText());

			} else {
				sayButton.setEnabled(false);
			}

		}

		else

		if (arg0.getSource() == passButton) {
			if (scene.prePassed()) {
				scene.passed();
			} else {
				passButton.setEnabled(false);
			}

		}

		else

		if (arg0.getSource() == failButton) {
			if (scene.preFailed()) {
				scene.failed();
			} else {

				failButton.setEnabled(false);
			}
		}

	}

	public void processInput() {
	}

}
