package tp.pr5.mv.comm;

import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;

/**
 * Hace que la TPMV ejecute una instruccion (la siguiente del programa-mv de acuerdo al
 * contador de programa).
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class Step extends CommandInterpreter{

	/**
	 * Default constructor
	 */
	public Step(){
		super();
	}
	
	/**
	 * Sobreescritura metodo toString().
	 */
	public String toString(){
		return "STEP";
	}

	/**
	 * Ejecuta la siguiente instruccion del programa cargado en la CPU
	 * @return true - Si y solo si se ejecuto con exito la siguiente instruccion.
	 * @throws DivByZero 
	 * @throws InstructionMemoryException 
	 * @throws InstructionExecutionException 
	 */
	public boolean executeCommand() throws InstructionExecutionException, InstructionMemoryException, DivByZero {
		boolean check = false;
		check = cpu.step();
		return check;
	}

	/**
	 * Parser
	 */
	public CommandInterpreter parse(String line) {
		CommandInterpreter ci = null;
		String[] ld = line.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("STEP")){
			ci = new Step();
		}
		return ci;
	}

}
