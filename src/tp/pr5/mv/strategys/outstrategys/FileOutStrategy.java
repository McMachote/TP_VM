package tp.pr5.mv.strategys.outstrategys;

import java.io.IOException;
import java.io.OutputStream;

import tp.pr5.mv.MVC.IObservers.OutObserver;

public class FileOutStrategy implements OutStrategy {

	private OutputStream fichero;
	
	public FileOutStrategy(OutputStream out){
		this.fichero = out;
	}
	
	public void write(char mander) {
		try{
			fichero.write(mander);
		}catch(IOException io){
			System.out.println(io);
		}
	}

	public String getName() {
		return "FileOutStrategy";
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