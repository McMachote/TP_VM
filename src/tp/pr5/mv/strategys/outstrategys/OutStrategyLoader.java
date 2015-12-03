package tp.pr5.mv.strategys.outstrategys;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import tp.pr5.mv.Constants;

public class OutStrategyLoader {

	private OutStrategy outstrategy;
	
	public OutStrategyLoader (String outf, String mode) {
		this.outstrategy = null;
		if(outf == null){// NO existe fichero salida
			if(mode == null || mode.equalsIgnoreCase("BATCH")){
				outstrategy = new ConsoleOutStrategy();
			}
			else{
				if(!mode.equalsIgnoreCase("WINDOW")){
					outstrategy = new NullOutStrategy();
				}
				else{
					outstrategy = new WindowOutStrategy(new NullOutStrategy());
				}
			}
		}
		else{// existe fichero salida
			try{
				FileOutputStream outStream = new FileOutputStream (outf);
				if(!mode.equalsIgnoreCase("WINDOW")){
					outstrategy = new FileOutStrategy(outStream);
				}
				else{
					outstrategy = new WindowOutStrategy(new FileOutStrategy(outStream));
				}
			}catch(FileNotFoundException fnfe){
				System.err.println("Uso incorrecto: Error al acceder al fichero de salida (" + outf + ")" + Constants.LS +
						"Use -h|--help para mas detalles.");
				System.exit(1);
			}
		}
	}
	
	public OutStrategy getOutStrategy(){
		return this.outstrategy;
	}
	
}
