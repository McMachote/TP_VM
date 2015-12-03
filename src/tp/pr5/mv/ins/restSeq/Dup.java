package tp.pr5.mv.ins.restSeq;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

/**
 * 
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class Dup extends RestSec{

	/**
	 * Default constructor
	 */
	public Dup(){
		super();
	}
	
	/**
	 * Duplica el valor de la cima de operandos.
	 * @return true si se ejecuto con exito
	 * @throws InstructionExecutionException 
	 */
	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs)
			throws InstructionExecutionException{
		if(os.size() > 0){
			int aux = os.getCima();
			os.push(aux);
		}
		else{
			throw new InstructionExecutionException(toString(), os.size());
		}
	}

	public String toString() {
		return "DUP";
	}

	public Instruction parse(String s) {
		Instruction instr = null;
		String ld[] = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("DUP") ){
			instr = new Dup();
		}
		return instr;
	}

}
