package tp.pr5.mv.ins.restSeq;

import tp.pr5.mv.Constants;
import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

/**
 * POP
 * @author Rayner Tan Luc & Juan Miguel lacruz Camblor
 */
public class Pop extends RestSec{

	/**
	 * Default constructor
	 */
	public Pop(){
		super();
	}
	
	/**
	 * Extrae un elemento de la cima de la pila
	 * @return true si se ha ejecutado con exito
	 * @throws InstructionExecutionException 
	 */
	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs)
			throws InstructionExecutionException{
		boolean check = os.pop();
		if(!check){
			System.out.println(Constants.EXE_FAIL + " POP");
		}
	}

	/**
	 * Sobreescritura toString()
	 */
	public String toString() {
		return "POP";
	}

	/**
	 * Parser.
	 */
	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("POP") ){
			instr = new Pop();
		}
		return instr;
	}

}
