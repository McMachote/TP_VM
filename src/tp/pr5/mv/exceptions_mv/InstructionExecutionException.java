package tp.pr5.mv.exceptions_mv;

import tp.pr5.mv.Constants;

public class InstructionExecutionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InstructionExecutionException(String s){
		super(s);
	}

	public InstructionExecutionException(String s, int n){
		super(Constants.INST_EXE_FAIL + s + ": " +
				"faltan operandos en la pila (hay " + n + ")");
	}
	
}
