package tp.pr5.mv.comm;

import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;

/**
 * Ejecuta completamente todas las instrucciones del programa cargado en CPU hasta su terminacion.
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class Run extends Step {

	/**
	 * Default constructor
	 */
	public Run(){
		super();
	}
	
	/**
	 * Sobreescritura metodo toString().
	 */
	public String toString() {
		return "RUN";
	}

	/**
	 * Ejecutar.
	 * @throws DivByZero 
	 * @throws InstructionMemoryException 
	 * @throws InstructionExecutionException 
	 */
	public boolean executeCommand() throws InstructionExecutionException, InstructionMemoryException, DivByZero {
		boolean check = true;
		Step paso = new Step();
		while(check){
			check = paso.executeCommand();
		}
		return check;
	}

	/**
	 * Parser.
	 */
	public CommandInterpreter parse(String line){
		CommandInterpreter ci = null;
		if(line.equalsIgnoreCase("RUN")){	
			ci = new Run();
		}
		return ci;
	}
	
}
