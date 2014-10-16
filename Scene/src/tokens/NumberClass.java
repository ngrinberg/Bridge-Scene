package tokens;
import interfaces.Numberterface;

import util.annotations.Explanation;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"editableInput","readOnlyInput","edit" })
@EditablePropertyNames({"editableInput","edit" })
@Explanation("This class takes user inputted number token, turns it into an integer and returns it.")
@Tags({"Number Token"})// tagz

public class NumberClass implements Numberterface {//implements both the general token class interface for the editable as well as an additional interface this is a long sentence.

	String editableInput;
	int readOnlyInput;
	String edit;

	public NumberClass(String userInput)
	{
		editableInput=userInput;
		readOnlyInput=Integer.parseInt(editableInput);


	}

	public void setEdit()
	{
		edit=editableInput;
	}
	public String getEdit()
	{
		return edit;

	}
	
	public int getReadOnlyInput()
	{

		return readOnlyInput;



	}



}
