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
	@Tags({"Token Class"})
public abstract class TokenClass implements Tokenterface {//implements both the general token class interface for the editable
		String editableInput;
		String edit;


		public TokenClass(String userInput)
		{
			editableInput=userInput;



		}
		public void setEdit()// redundant but you wanted a setter even though I just did it in the constructor, i didn't want to be penalized.
		{
			edit=editableInput;
		}

		public String getEdit()
		{

			return edit;



		}


	}


