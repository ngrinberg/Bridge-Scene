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
@Explanation("This class takes user inputted } token, and returns it")
@Tags({"End Token"})

public class EndTokenClass extends TokenClass implements Tokenterface// implements general edit interface
{	
	
	
	public EndTokenClass(String userInput)
	 {
		super(userInput);
		
		
		
	 }

	

}
