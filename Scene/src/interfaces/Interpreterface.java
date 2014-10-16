package interfaces;



public interface Interpreterface {
	public void setEnteredCommand(String entered);
	public Runnable sayParse();
	public Runnable moveParse();
	public void animateLancelot();
	public void animateGalahad();
	public void animateRobin();
	public void animateArthur();
	public void animateGuard();
	public String getEnteredCommand();
	public Runnable failParse();
	public Runnable repeatParse();
	public Runnable passParse();
	public Runnable commandParse();
	public Runnable approachParse();
	public Runnable commandListParse();
	public void startAnimate();
	public void waitArthur();
	public void waitRobin() ;
	public void waitLancelot(); 
	public void waitGalahad();
	public Runnable rotateLeftArmParse();
	public Runnable rotateRightArmParse();
	public Runnable waitParse();
	public Runnable proceedAllParse();
	public Runnable sleepParse();
	public Runnable defineParse();
	public Runnable callParse();
	public void LockstepArthur();
	public void LockstepRobin();
	public void LockstepLancelot();
	public void LockstepGalahad();
	public void LockstepGuard();
}
