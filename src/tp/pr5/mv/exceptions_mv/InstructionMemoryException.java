package tp.pr5.mv.exceptions_mv;

import tp.pr5.mv.Constants;

public class InstructionMemoryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InstructionMemoryException(String s){
		super(s);
	}

	public InstructionMemoryException(String s, int n){
		super(Constants.INST_EXE_FAIL + s + ": Direccion incorrecta (" + n + ")");
	}
}
