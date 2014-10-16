package commands;
	
import interfaces.Wordterface;
import tokens.CommandClass;
import util.annotations.Explanation;
import util.annotations.Tags;
//import util.annotations.EditablePropertyNames;
//import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
	@StructurePattern(StructurePatternNames.BEAN_PATTERN)
	//@PropertyNames({"editableInput","readOnlyInput","edit" })
	//@EditablePropertyNames({"editableInput","edit" })
	@Explanation("This class takes a token and converts it to lowercase")
	@Tags({"thread"})
	
	public class ThreadClass extends CommandClass implements Wordterface {//implements both the general token class interface for the editable as well as an additional interface this is a long sentence.

		public ThreadClass(String userInput)
		{
			super(userInput);

		}
		



	}


