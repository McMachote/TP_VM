package tp.pr5.mv.strategys.instrategys;

import java.io.IOException;
import java.io.InputStream;

import tp.pr5.mv.MVC.IObservers.InObserver;

public class FileInputStrategy implements InStrategy {

	private InputStream archivo;

	public FileInputStrategy(InputStream f){
		this.archivo = f;
	}

	public int read() {
		int n = -1;
		try{
			n = this.archivo.read();
		}catch(IOException e){
			return -1;
		}
		return n;
	}

	public String getName() {
		return "FileInputStrategy";
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
