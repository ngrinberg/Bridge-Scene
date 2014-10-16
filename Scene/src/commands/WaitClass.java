package commands;
	
import interfaces.Wordterface;
import tokens.CommandClass;
import util.annotations.Explanation;
import util.annotations.Tags;
//import util.annotations.EditablePropertyNames;
//import util.annotations.PropertyNames;
	//@PropertyNames({"readOnlyInput","edit" })
	//@EditablePropertyNames({"edit" })
	@Explanation("This class takes a token and converts it to lowercase")
	@Tags({"wait"})
	
	public class WaitClass extends CommandClass implements Wordterface {//implements both the general token class interface for the editable as well as an additional interface this is a long sentence.

		public WaitClass(String userInput)
		{
			super(userInput);

		}
		




	}



