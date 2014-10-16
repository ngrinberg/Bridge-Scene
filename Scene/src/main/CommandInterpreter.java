package main;

import main.AvatarAnimator;
import tokens.EndTokenClass;
import tokens.NumberClass;

import tokens.StartTokenClass;
import tokens.WordClass;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
//import util.annotations.EditablePropertyNames;
import util.annotations.Tags;
import commands.ApproachClass;
import commands.CallClass;
import commands.DefineClass;
import commands.FailClass;
import commands.MoveClass;
import commands.PassClass;
import commands.ProceedAallClass;
import commands.RepeatClass;
import commands.RotateLeftArmClass;
import commands.RotateRightArm;
import commands.SayClass;
import commands.SleepClass;
import commands.WaitClass;
import interfaces.AvatarAnimaterface;
import interfaces.Avatarface;
import interfaces.BroadcastingClearanceManager;

import interfaces.CommandListerface;
import interfaces.GuardAnimaterface;
import interfaces.Interpreterface;
import interfaces.Numberterface;
import interfaces.Scannerterface;
import interfaces.Tableterface;
import interfaces.Tokenterface;
import interfaces.Universe;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({ "Command Interpreter" })
@PropertyNames({ "enteredCommand" })
@EditablePropertyNames({ "enteredCommand" })
public class CommandInterpreter implements Interpreterface {

	String enteredCommand;
	Avatarface avatar;
	Universe bridgeScene = new AUniverse();
	Tokenterface[] tokenArray;
String word;
int count=0;
int times;
	int x;
	int y;
	Tableterface<String,Object> tablez;
	Scannerterface beanScanner = new Scannerz();
	AvatarAnimaterface animatorGalahad;
	AvatarAnimaterface animatorArthur;
	AvatarAnimaterface animatorRobin;
	AvatarAnimaterface animatorLancelot;
	AvatarAnimaterface waitGalahad;
	AvatarAnimaterface waitArthur;
	AvatarAnimaterface waitRobin;
	AvatarAnimaterface waitLancelot;
	AvatarAnimaterface lockstepGalahad;
	AvatarAnimaterface lockstepArthur;
	AvatarAnimaterface lockstepRobin;
	AvatarAnimaterface lockstepLancelot;
	GuardAnimaterface animatorGuard;
	GuardAnimaterface lockstepGuard;
	BroadcastingClearanceManager clear;
	Tableterface<String,Object> table;

	public CommandInterpreter(Universe bS, Scannerterface beaSca,BroadcastingClearanceManager manage) {
		clear=manage;
		bridgeScene = bS;
		beanScanner = beaSca;
		tablez = new TableClass<String, Object>();
		table=new TableClass<String,Object>();
		enteredCommand = "";
		tablez.put("arthur", (Object) bridgeScene.getArthur());
		tablez.put("robin", (Object) bridgeScene.getRobin());
		tablez.put("galahad", (Object) bridgeScene.getGalahad());
		tablez.put("lancelot", (Object) bridgeScene.getLancelot());
		tablez.put("guard", (Object) bridgeScene.getGuard());
		
		animatorArthur=new AvatarAnimate(
				(Avatarface) tablez.get("arthur"));
		animatorLancelot=new AvatarAnimate(
				(Avatarface) tablez.get("lancelot"));
		animatorRobin=new AvatarAnimate(
				(Avatarface) tablez.get("robin"));
		animatorGuard=new AnimateGuard(
				(Avatarface) tablez.get("guard"));
		animatorGalahad=new AvatarAnimate(
				(Avatarface) tablez.get("galahad"));
		
		
		waitArthur=new WaitingAnimate(
				(Avatarface) tablez.get("arthur"),clear);
		waitLancelot=new WaitingAnimate(
				(Avatarface) tablez.get("lancelot"),clear);
		waitRobin=new WaitingAnimate(
				(Avatarface) tablez.get("robin"),clear);
	
		waitGalahad=new WaitingAnimate(
				(Avatarface) tablez.get("galahad"),clear);
		
		
		lockstepGuard=new LockstepGuard(
				(Avatarface) tablez.get("guard"),clear);
		lockstepArthur=new LockstepAnimate(
				(Avatarface) tablez.get("arthur"),clear);
		lockstepLancelot=new LockstepAnimate(
				(Avatarface) tablez.get("lancelot"),clear);
		lockstepRobin=new LockstepAnimate(
				(Avatarface) tablez.get("robin"),clear);
	
		lockstepGalahad=new LockstepAnimate(
				(Avatarface) tablez.get("galahad"),clear);
	}

	public String getEnteredCommand() {
		return enteredCommand;
	}

	public void setEnteredCommand(String entered) {
		count=0;
		enteredCommand = entered;
		beanScanner.setUserInput(enteredCommand);
		tokenArray = new Tokenterface[beanScanner.getTokenArray().length];
		tokenArray = beanScanner.getTokenArray();
	
          Runnable commandGeneric= commandParse();
          commandGeneric.run();
	}

	@Tags({ "asynchronous Arthur" })
	public void animateArthur() {// creates a thread that passes an avatar
									// through to the animating command which
									// exceutes the animator class with that
									// avatar
		
		Thread thread1 = new Thread(new AvatarAnimator(animatorArthur, 15, 16));
		thread1.start();

	}

	@Tags({ "asynchronous Robin" })
	public void animateRobin() {
		
		Thread thread2 = new Thread(new AvatarAnimator(animatorRobin, 15, 16));
		thread2.start();

	}

	@Tags({ "asynchronous Galahad" })
	public void animateGalahad() {
		
		Thread thread3 = new Thread(new AvatarAnimator(animatorGalahad, 15, 14));
		thread3.start();
	}

	@Tags({ "asynchronous Lancelot" })
	public void animateLancelot() {
		
		Thread thread4 = new Thread(
				new AvatarAnimator(animatorLancelot, 14, 15));
		thread4.start();
	}

	@Tags({ "asynchronous guard" })
	public void animateGuard() {
	
		Thread thread5 = new Thread(new GuardAnimator(animatorGuard, 500));
		thread5.start();

	}
	@Tags({ "waiting Arthur" })
	public void waitArthur() {
		Thread thread1 = new Thread(new AvatarAnimator(waitArthur, 5, 6));
		thread1.start();
	}
	
	@Tags({ "waiting Robin" })
	public void waitRobin() {
		Thread thread2 = new Thread(new AvatarAnimator(waitRobin, 5, 6));
		thread2.start();
	}
	@Tags({ "waiting Lancelot" })
	public void waitLancelot() {
		Thread thread4 = new Thread(new AvatarAnimator(waitLancelot, 4, 5));
		thread4.start();
	}
	@Tags({ "waiting Galahad" })
	public void waitGalahad() {
		Thread thread3 = new Thread(new AvatarAnimator(waitGalahad, 5, 4));
		thread3.start();
	}
	@Tags({"start animation"})
	public void startAnimate()
	{
		clear.proceedAll();
	}
	@Tags({ "lockstep Arthur" })
	public void LockstepArthur() {
		Thread thread1 = new Thread(new AvatarAnimator(lockstepArthur, 5, 6));
		thread1.start();
	}
	
	@Tags({ "lockstep Robin" })
	public void LockstepRobin() {
		Thread thread2 = new Thread(new AvatarAnimator(lockstepRobin, 10, 10));
		thread2.start();
	}
	@Tags({ "lockstep Lancelot" })
	public void LockstepLancelot() {
		Thread thread4 = new Thread(new AvatarAnimator(lockstepLancelot, 10, 10));
		thread4.start();
	}
	@Tags({ "lockstep Galahad" })
	public void LockstepGalahad() {
		Thread thread3 = new Thread(new AvatarAnimator(lockstepGalahad, 10, 10));
		thread3.start();
	}
	@Tags({ "lockstep Guard" })
	public void LockstepGuard() {
		Thread thread3 = new Thread(new GuardAnimator(lockstepGuard, 500));
		thread3.start();
	}
	
	public Runnable moveParse() {// checks if the string has appropriate syntax
		count++;					// move avatar int int
		if (tokenArray[count] instanceof WordClass
				&& tokenArray[count+1] instanceof NumberClass
				&& tokenArray[count+2] instanceof NumberClass) {
			String key;
			key = tokenArray[count].getEdit(); // gets word in token array
			x = ((Numberterface) tokenArray[count+1]).getReadOnlyInput();// gets ints
			y = ((Numberterface) tokenArray[count+2]).getReadOnlyInput();

			avatar = (Avatarface) (tablez.get(key));
		}
		Runnable newRun = new MoveCommand(avatar, x, y);// creates runnable
														// object of the move
														// command class and
					count=count+2;									// passes through avatar
														// and the ints

		return newRun;// returns runnable object

	}
	@Tags({"command list parser"})
	
	public Runnable commandListParse() 
	{
		
		CommandListerface newRunz = new CommandList();
		
	  count++;
		
	  while(!(tokenArray[count] instanceof EndTokenClass))
	  {
			newRunz.addCommands(commandParse());//adds untill hits an end token 
			count++;
			
	  }

		


		return newRunz;

	}
	
	@Tags({"approach parser"})
	public Runnable approachParse() {
		count++;
		if (tokenArray[count] instanceof WordClass) {
			 word = (tokenArray[count]).getEdit();
			
		}
		Runnable newRunz = new ApproachCommand(bridgeScene,(Avatarface) tablez.get(word));
		
		
		return newRunz;

	}
	
	@Tags({"command parser"})
	
public Runnable commandParse() {
	
	
		if (tokenArray[count] instanceof SayClass)
		{
			
			return sayParse();
			
		}
		else if (tokenArray[count] instanceof MoveClass)
		{
			
			return moveParse();
			
		}
		else if (tokenArray[count] instanceof PassClass)
		{
			return passParse();
			
		}
		else if (tokenArray[count] instanceof FailClass)
		{
			return failParse();
			
		}
		else if (tokenArray[count] instanceof RepeatClass)
		{
			return repeatParse();
			
		}
		else if (tokenArray[count] instanceof ApproachClass)
		{
			return approachParse();
			
		}
		else if(tokenArray[count] instanceof StartTokenClass)
		{
			
			return commandListParse();
		}
		else if(tokenArray[count] instanceof RotateLeftArmClass )//extended grammar starts here
		{
			return rotateLeftArmParse();
		}
		else if (tokenArray[count] instanceof RotateRightArm )
		{
			return rotateRightArmParse();
		}
		else if (tokenArray[count] instanceof WaitClass )
		{
			return waitParse();
		}
		
		else if (tokenArray[count] instanceof ProceedAallClass )
		{
			return proceedAllParse();
		}
		else if (tokenArray[count] instanceof SleepClass)
		{
			return sleepParse();
		}
		else if (tokenArray[count] instanceof DefineClass )
		{
			return defineParse();
		}
		else if (tokenArray[count] instanceof CallClass )
		{
			return callParse();
		}
	
		return null;
		

	}
	@Tags({"rotateLeftArmParse"})
	public Runnable rotateLeftArmParse()
	{
		count++;
	
	

		
		String key;
		key = tokenArray[count].getEdit(); 
		Avatarface avatarz = (Avatarface) (tablez.get(key));// gets avatar
		count++;
		int degrees = ((Numberterface) tokenArray[count]).getReadOnlyInput();
		
		
		Runnable newRunz = new RotateLeftArm(avatarz,degrees);
		
		return newRunz;
		
	}
	@Tags({"rotateRightArmParse"})
	public Runnable rotateRightArmParse()
	{
		count++;
		
		 // gets word in token array

			String key;
			key = tokenArray[count].getEdit(); 
			Avatarface avatarz = (Avatarface) (tablez.get(key));
			count++;
			int degrees = ((Numberterface) tokenArray[count]).getReadOnlyInput();
			
			
			Runnable newRunz = new RotateRightArmCommand(avatarz,degrees);
			
			return newRunz;
	}
	@Tags({"waitParse"})
	public Runnable waitParse()
	{
		count++;
		Runnable newRunz = new WaitCommand(clear);
		
		return newRunz;
	}
	@Tags({"proceedAllParse"})
	public Runnable proceedAllParse()
	{
		count++;
		Runnable newRunz = new ProceedAllCommand(clear);

		return newRunz;
	}
	@Tags({"sleepParse"})
	public Runnable sleepParse()
	{
		count++;
		int number = ((Numberterface) tokenArray[count]).getReadOnlyInput();
		Runnable newRunz = new SleepCommand(number);
	count++;
		return newRunz;
	}
	@Tags({"defineParse"})
	public Runnable defineParse()
	{
		count++;
		String name = tokenArray[count].getEdit(); 
		count++;
		Runnable newRunz = new DefineCommand(name,commandParse(),table);//takes in a string,object table type a key name and a command
		
		return newRunz;
	}
	@Tags({"callParse"})
	public Runnable callParse()
	{
		count++;
		String name = tokenArray[count].getEdit(); 
     Runnable newRunz = new CallCommand(name,table);
		count++;
		return newRunz;
	}
	@Tags({"pass parser"})
	public Runnable passParse() {
		count++;
		Runnable newRunz = new PassCommand(bridgeScene);
		
		return newRunz;

	}
	//@Tags({"command list parser"})
	
	@Tags({"repeat parser"})
   public Runnable repeatParse() {
      count++;	
		if( tokenArray[count] instanceof NumberClass) {
	 // gets word in token array
			 times = ((Numberterface) tokenArray[count]).getReadOnlyInput();
		}
		count++;
		Runnable newRunz = new RepeatCommand(times,commandParse());
		
		return newRunz;

	}
	
	@Tags({ "fail parser" })
	public Runnable failParse() {
		count++;
		Runnable newRunz = new FailCommand(bridgeScene);
		
		return newRunz;

	}
	@Tags({ "say parser" })
	public Runnable sayParse() {
		count++;
			String word = (tokenArray[count]).getEdit();
			bridgeScene.sayScene(word);
		
		Runnable newRunz = new SayCommand(bridgeScene,word);
	
		return newRunz;

	}
}
