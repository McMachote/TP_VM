package tp.pr5.mv.strategys.instrategys;

import tp.pr5.mv.MVC.IObservers.InObserver;

public interface InStrategy {
	
	public int read ();
	
	public String getName();

	public void addObs(InObserver inObs);
	
}
