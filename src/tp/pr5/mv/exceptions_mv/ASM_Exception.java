package tp.pr5.mv.exceptions_mv;

import tp.pr5.mv.Constants;

public class ASM_Exception extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ASM_Exception(){
		super("Uso incorrecto: Fichero ASM no especificado." + Constants.LS
				+ "Use -h|--help para mas detalles.");
	}
	
	public ASM_Exception(String s){
		super("Error en el programa. Linea: " + s);
	}
	
}
