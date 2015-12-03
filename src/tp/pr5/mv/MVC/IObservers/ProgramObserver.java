package tp.pr5.mv.MVC.IObservers;

public interface ProgramObserver {

	/**
	 * Returns the current execution instruction
	 * @return int - CurrentPc
	 */
	public int onStep();
	public void onClear();
	
}
