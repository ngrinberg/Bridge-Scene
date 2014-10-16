package main;
import interfaces.Numberterface;
import interfaces.Scannerterface;
import interfaces.Tokenterface;
import interfaces.Wordterface;
import commands.ApproachClass;
import commands.CallClass;
import commands.DefineClass;
import commands.FailClass;
import commands.MoveClass;
import commands.PassClass;
import commands.ProceedAallClass;
import commands.RedoClass;
import commands.RepeatClass;
import commands.RotateLeftArmClass;
import commands.RotateRightArm;
import commands.SayClass;
import commands.SleepClass;
import commands.ThreadClass;
import commands.UndoClass;
import commands.WaitClass;
import tokens.EndTokenClass;
import tokens.NumberClass;
import tokens.QuoteClass;
import tokens.StartTokenClass;
import tokens.WordClass;
import util.annotations.Explanation;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@PropertyNames({"userInput","tokenArray" })
@EditablePropertyNames({"userInput" })
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Explanation("This class takes user input as a string and splits it up in tokens: word, number, quote, {, and }")
@Tags({"Scanner Bean"})

public class Scannerz implements Scannerterface {

	//global variable declarations
	Tokenterface[] tokenArray;// declaring compact array
	
	String userInput;// test case strings
	int counter=1;// deals with quote

	public Scannerz()// constructor Scanning 
	{

		 
	}
	public void setUserInput(String newInput)// sets the input given by the driver class so it can be retrieved in the OE and sends it to the method that separates the tokens
	{ userInput = newInput; 
	 setScanner(userInput);
	}
	public String getUserInput()// retrieves string for OE
	{
		
		return userInput;
	}
	
	public Tokenterface[] getTokenArray()// retrieves compact array of objects for OE
	{
		
		return tokenArray;
	}
	

	public void setScanner(String userInput)// method set
	{  Tokenterface tempArray[]=new Tokenterface [100];// new temporary array with arbitrary amount of numbers
		//reset each variable so new input can be passed
		String startToken="";
		String endToken="";
		String empty="";
		String wordBuilder="";
		userInput+=" ";
		String quoteBuilder="";
		int count=0;//Will be 1, 2, or 3, 4 or 5 based on the type of substring (number, word, quoted word, {, })
		boolean end=false;
		int arrayCount=0;// counter to find the number of objects in each string 
		
		

		for(int index=0; index<userInput.length(); index++)// goes through each character in string
		{

			

			if(counter==-1 && userInput.charAt(index)!= '"')
			{


				quoteBuilder+=userInput.charAt(index);// builds quotation


			}
			else
			{


				if(Character.isDigit(userInput.charAt(index)))// checks if character in the string is a digit
				{ 
					count=2;

					empty+=userInput.charAt(index);//builds number



				}


				if (Character.isLetter(userInput.charAt(index)))
				{
					count=3;


					wordBuilder+=userInput.charAt(index);// builds word

				}

				if(userInput.charAt(index)=='{')
				{   count=4;
				startToken+=userInput.charAt(index);// recognizes {



				}
				if(userInput.charAt(index)=='}')
				{
					count=5;
					endToken+=userInput.charAt(index);// recognizes }



				}
				if(userInput.charAt(index)=='"')
				{ 

					count=1;
					counter*=-1;//multipies by -1 when it sees a " in the string so it knows to build quote instead of word until it hits another " and is set to 1 again

				}
			}		
			if(counter==1 && count==1)
			{end=true;//checks if you can output the string
			}
			if(count!=1 && userInput.charAt(index)==' ')
			{end=true;
			}
			if(end && count==1)// its a quote
			{Tokenterface quoted=new QuoteClass(quoteBuilder);
			quoted.setEdit();// calls properties
			quoted.getEdit();
			tempArray[arrayCount]=quoted;// stores object in array
			
			arrayCount++;// add 1 to number of objects in array
			}

			if(end && count==4)
			{
				Tokenterface startTok=new StartTokenClass(startToken);
               

				startTok.setEdit();
				startTok.getEdit();
				tempArray[arrayCount]=startTok;
				arrayCount++;
				
			}
			if(end && count==5)
			{
				Tokenterface endTok=new EndTokenClass(endToken);// creates new instance of class endToken type Tokenterface
				endTok.setEdit();
				endTok.getEdit();
				tempArray[arrayCount]=endTok;
				arrayCount++;
			
			}

			if(end && count==2)
			{
				Numberterface numz=new NumberClass(empty);
				numz.setEdit();
				numz.getEdit();
				tempArray[arrayCount]=numz;
				arrayCount++;
			}

			if(end && count==3)// its a word but what type of word?
			{
				if(wordBuilder.equalsIgnoreCase("move"))// checks to see if the word is actually a command
				{
					Wordterface moveCommand=new MoveClass(wordBuilder);// if so then create instance of the command class
					
					moveCommand.setEdit();
					moveCommand.getEdit();
					
					tempArray[arrayCount]=moveCommand;// store object
					arrayCount++;
				}
				else

					if(wordBuilder.equalsIgnoreCase("call"))
					{

						Wordterface callCommand=new CallClass(wordBuilder);
						callCommand.setEdit();
						callCommand.getEdit();
						
						tempArray[arrayCount]=callCommand;
						arrayCount++;
					}
					else
						if(wordBuilder.equalsIgnoreCase("repeat"))
						{

							Wordterface repeatCommand=new RepeatClass(wordBuilder);
							repeatCommand.setEdit();
							repeatCommand.getEdit();
							
							tempArray[arrayCount]=repeatCommand;
							arrayCount++;
						}
						else
							if(wordBuilder.equalsIgnoreCase("say"))
							{

								Wordterface sayCommand=new SayClass(wordBuilder);
								sayCommand.setEdit();
								sayCommand.getEdit();
								tempArray[arrayCount]=sayCommand;
								arrayCount++;
							}
							else
								if(wordBuilder.equalsIgnoreCase("rotateLeftArm"))
								{
									Wordterface rotateLeftArmCommand=new RotateLeftArmClass(wordBuilder);
									rotateLeftArmCommand.setEdit();
									rotateLeftArmCommand.getEdit();
									
									tempArray[arrayCount]=rotateLeftArmCommand;
									arrayCount++;
								}
								else
									if(wordBuilder.equalsIgnoreCase("rotateRightArm"))
									{
										Wordterface rotateRightArmCommand=new RotateRightArm(wordBuilder);
										rotateRightArmCommand.setEdit();
										rotateRightArmCommand.getEdit();
										tempArray[arrayCount]=rotateRightArmCommand;
										arrayCount++;
									}
									else
										if(wordBuilder.equalsIgnoreCase("define"))
										{

											Wordterface defineCommand=new DefineClass(wordBuilder);
											
											defineCommand.setEdit();
											defineCommand.getEdit();
											tempArray[arrayCount]=defineCommand;
											arrayCount++;
										}
										else
											if(wordBuilder.equalsIgnoreCase("thread"))
											{

												Wordterface threadCommand=new ThreadClass(wordBuilder);
												threadCommand.setEdit();
												threadCommand.getEdit();
												tempArray[arrayCount]=threadCommand;
												arrayCount++;
											}
											else
												if(wordBuilder.equalsIgnoreCase("wait"))
												{
													Wordterface waitCommand=new WaitClass(wordBuilder);
													
													waitCommand.setEdit();
													waitCommand.getEdit();
													tempArray[arrayCount]=waitCommand;
													arrayCount++;

												}
												else
													if(wordBuilder.equalsIgnoreCase("proceedAll"))
													{

														Wordterface proceedCommand=new ProceedAallClass(wordBuilder);
														proceedCommand.setEdit();
														proceedCommand.getEdit();
														
														tempArray[arrayCount]=proceedCommand;
														arrayCount++;
													}
													else
														if(wordBuilder.equalsIgnoreCase("sleep"))
														{

															Wordterface sleepCommand=new SleepClass(wordBuilder);
															sleepCommand.setEdit();
															sleepCommand.getEdit();
															tempArray[arrayCount]=sleepCommand;
															arrayCount++;
														}
														else
															if(wordBuilder.equalsIgnoreCase("undo"))
															{
																Wordterface undoCommand=new UndoClass(wordBuilder);
																undoCommand.setEdit();
																undoCommand.getEdit();
																
																tempArray[arrayCount]=undoCommand;
																arrayCount++;
															}
															else
																if(wordBuilder.equalsIgnoreCase("redo"))
																{

																	Wordterface redoCommand=new RedoClass(wordBuilder);
																	redoCommand.setEdit();
																	redoCommand.getEdit();
																	
																	tempArray[arrayCount]=redoCommand;
																	arrayCount++;
																}
																else
																	if(wordBuilder.equalsIgnoreCase("approach"))
																	{
																		
																		Wordterface approachCommand=new ApproachClass(wordBuilder);
																		approachCommand.setEdit();
																		approachCommand.getEdit();
																		
																		tempArray[arrayCount]=approachCommand;
																		arrayCount++;
																		
																		
																	} 
																	else
																		if(wordBuilder.equalsIgnoreCase("pass"))
																		{
																			
																			Wordterface passCommand=new PassClass(wordBuilder);
																			passCommand.setEdit();
																			passCommand.getEdit();
																			
																			tempArray[arrayCount]=passCommand;
																			arrayCount++;
																			
																			
																		}
																		else
																			if(wordBuilder.equalsIgnoreCase("fail"))
																			{
																				
																				Wordterface failCommand=new FailClass(wordBuilder);
																				failCommand.setEdit();
																			       failCommand.getEdit();
																				
																				tempArray[arrayCount]=failCommand;
																				arrayCount++;
																				
																				
																			}
																else
																{
																    Wordterface wordz=new WordClass(wordBuilder);
																	wordz.setEdit();
																	wordz.getEdit();
																	tempArray[arrayCount]=wordz;
																	arrayCount++;
																
																}
			
			    }









			if(end)//clears everything/sets to false
			{
				startToken="";
				endToken="";
				empty="";
				wordBuilder="";
				quoteBuilder="";
				end=false;
				count=0;
				
				
				
			}
			
		}
	 
	
	    tokenArray=new Tokenterface [arrayCount];// creates a new tokenArray with arrayCount # of objects
		
	    for(int j=0; j<arrayCount; j++)
		{
          tokenArray[j]=tempArray[j];
		}
		//copies objects in the large temp array to the new array starting at 0 and ending at arrayCount
		
			
		
		
	}
	
	
	
} 




