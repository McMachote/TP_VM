package tp.pr5.mv.strategys.instrategys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import tp.pr5.mv.Constants;

public class InStrategyLoader {

	private InStrategy instrategy;
	
	public InStrategyLoader (String infile, String mode) {
		this.instrategy = null;
		try {
			if(infile == null){
				if(mode.equalsIgnoreCase("BATCH")){
					instrategy = new ConsoleInputStrategy();
				}
				else {// if(mode.equalsIgnoreCase("interactive") || mode.equalsIgnoreCase("window")){
					instrategy = new NullInputStrategy();
				}
			}
			else{
				InputStream inputstream = new FileInputStream(infile);
				if(!mode.equalsIgnoreCase("WINDOW")){ 
					instrategy = new FileInputStrategy(inputstream);
				}
				else{
					instrategy = new WindowInStrategy(new FileInputStrategy(inputstream));
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println( "Uso incorrecto: Error al acceder al fichero de entrada (" + infile + ")" + Constants.LS +
								"Use -h|--help para mas detalles.");
			System.exit(1);
		}
	}
	
	public InStrategy getStrategy () {
		return this.instrategy;
	}
	
}
