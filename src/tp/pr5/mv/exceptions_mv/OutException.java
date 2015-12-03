package tp.pr5.mv.exceptions_mv;

import tp.pr5.mv.Constants;

public class OutException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OutException(){
		super("Uso incorrecto: Missing argument for option: o" + Constants.LS + 
				"Use -h|--help para mas detalles.");
	}

}
