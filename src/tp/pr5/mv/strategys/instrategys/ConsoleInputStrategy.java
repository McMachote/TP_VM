package tp.pr5.mv.strategys.instrategys;

import java.io.IOException;

import tp.pr5.mv.MVC.IObservers.InObserver;

public class ConsoleInputStrategy implements InStrategy {
	
	public ConsoleInputStrategy(){
	}
	
	public int read() {
		int n = -1;
		try {
			n = System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return n;
	}

	public String getName() {
		return "ConsoleInputStrategy";
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
