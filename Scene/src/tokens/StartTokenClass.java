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
   @Explanation("This class takes user inputted { token, and returns it")
   @Tags({"Start Token"})

public class StartTokenClass extends TokenClass implements Tokenterface {// does same as endtoken
	


	
	public StartTokenClass(String userInput)
	 {
		super(userInput);
		
		
		
	 }
	
	


}
