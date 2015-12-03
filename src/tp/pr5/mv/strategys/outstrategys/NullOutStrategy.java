package tp.pr5.mv.strategys.outstrategys;

import tp.pr5.mv.MVC.IObservers.OutObserver;

public class NullOutStrategy implements OutStrategy {

	public NullOutStrategy(){
		super();
	}

	public void write(char mander) {
		
	}
	
	public String toString(){
		return "";
	}

	public String getName() {
		return "NullOutStrategy";
	}
	
	/**
	 * No utilizado. Mantiene OutStrategys como un conjunto.
	 * Este metodo solo es util para WindowOutStrategy
	 */
	@Override
	public void addObs(OutObserver outObs) {
		// TODO Auto-generated method stub
		
	}
	
}
