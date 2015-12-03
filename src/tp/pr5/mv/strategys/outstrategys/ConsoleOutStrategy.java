package tp.pr5.mv.strategys.outstrategys;

import tp.pr5.mv.MVC.IObservers.OutObserver;

public class ConsoleOutStrategy implements OutStrategy{

	public ConsoleOutStrategy(){
		super();
	}

	public void write(char mander) {
		System.out.println(mander);
	}

	public String getName() {
		return "ConsoleOutStrategy";
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
