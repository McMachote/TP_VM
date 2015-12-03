package tp.pr5.mv.ins;

import tp.pr5.mv.Constants;
import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

/**
 * Clase que muestra el estado de la maquina.
 * Se invoca desde el comando debug => No esta incluido en instructionParser
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class Watch implements Instruction {

	/**
	 * Default constructor.
	 */
	public Watch(){
		super();
	}
	
	/**
	 * Parser
	 */
	public Instruction parse(String s) {
		Instruction instr = null;
		String ld[] = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("WATCH")){
			instr = new Watch();
		}
		return instr;
	}

	/**
	 * Hace push y pop, operacion neutra para ver el estado de la maquina.
	 * Instruccion exclusiva para debug.
	 */
	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs){
		String s = "";
		s += Constants.STATE + Constants.LS;
		s += mem.toString();
		s += os.toString();
		System.out.println(s);
	}

	/**
	 * Reescritura de toString()
	 */
	public String toString(){
		return "WATCH";
	}
	
}

