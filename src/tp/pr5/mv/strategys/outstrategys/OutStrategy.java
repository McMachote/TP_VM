package tp.pr5.mv.strategys.outstrategys;

import tp.pr5.mv.MVC.IObservers.OutObserver;

public interface OutStrategy {

	public void write(char mander);

	public String toString();

	public String getName();

	public void addObs(OutObserver outObs);

}
