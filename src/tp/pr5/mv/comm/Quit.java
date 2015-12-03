package tp.pr5.mv.comm;

import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.ins.restSeq.Halt;

/**
 * Comando que sale de la aplicacion.
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class Quit extends CommandInterpreter {

	/**
	 * Default constructor
	 */
	public Quit(){
		super();
	}
	
	/**
	 * Sobreescritura metodo toString
	 */
	@Override
	public String toString(){
		return "QUIT";
	}

	/**
	 * Ejecutar. Para la maquina.
	 * @return true - Siempre se puede para si se esta ejecutando.
	 * @throws DivByZero 
	 * @throws InstructionMemoryException 
	 * @throws InstructionExecutionException 
	 */
	public boolean executeCommand() throws InstructionExecutionException, InstructionMemoryException, DivByZero{
		Halt instr = new Halt();
		cpu.step(instr);
		return true;
	}

	/**
	 * Parser.
	 */
	public CommandInterpreter parse(String line) {
		CommandInterpreter ci = null;
		String[] ld = line.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("QUIT")){
			ci = new Quit();
		}
		return ci;
	}

}
