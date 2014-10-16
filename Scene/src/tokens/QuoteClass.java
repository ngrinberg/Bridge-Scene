package tokens;
import interfaces.Tokenterface;
import util.annotations.Explanation;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
	@StructurePattern(StructurePatternNames.BEAN_PATTERN)
	@PropertyNames({"editableInput","edit" })
	@EditablePropertyNames({"editableInput","edit" })
@Explanation("This class takes user inputted quote token and returns it.")
@Tags({"Quote Token"})

public class QuoteClass extends TokenClass implements Tokenterface {//implements both the general token class interface for the editable



	public QuoteClass(String userInput)
	{
		super(userInput);



	}


}
