package tp.pr5.mv.strategys.instrategys;

import tp.pr5.mv.MVC.IObservers.InObserver;

public class NullInputStrategy implements InStrategy {

	public NullInputStrategy(){
		
	}
	
	public int read() {
		return -1;
	}

	public String toString(){
		return "";
	}

	public String getName() {
		return "NullInputStrategy";
	}

	/**
	 * No utilizado. Mantiene Instrategys como un conjunto.
	 * Este metodo solo es util para WindowInStrategy
	 */
	@Override
	public void addObs(InObserver inObs) {
		// TODO Auto-generated method stub
		
	}

}
