package tokens;

import interfaces.Wordterface;
import util.annotations.Explanation;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
	@StructurePattern(StructurePatternNames.BEAN_PATTERN)
	@PropertyNames({"editableInput","readOnlyInput","edit" })
	@EditablePropertyNames({"editableInput","edit" })
@Explanation("This class takes a token and converts it to lowercase")
@Tags({"Word Token"})
public class WordClass implements Wordterface {//implements both the general token class interface for the editable as well as an additional interface this is a long sentence.

	String editableInput;
	   String readOnlyInput;
		String edit;

		public WordClass(String userInput)
		{
			editableInput=userInput;
			// sets userinput to editable prop
			readOnlyInput=editableInput.toLowerCase();


		}
		public void setEdit()
		{
			edit=editableInput;
		}
		public String getEdit()
		{
			return edit;// returns editable

		}

		public String getReadOnlyInput()
		{

			return readOnlyInput;



		}



}
