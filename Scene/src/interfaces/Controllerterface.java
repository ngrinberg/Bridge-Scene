package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface Controllerterface extends ActionListener {
	
	 public void actionPerformed(ActionEvent arg0);
	 public void processInput() ;
	 public void setModel(Interpreterface newCommand);
}
