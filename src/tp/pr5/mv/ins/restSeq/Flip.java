package tp.pr5.mv.ins.restSeq;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public class Flip extends RestSec{

	/**
	 * Default constructor
	 */
	public Flip(){
		super();
	}
	
	/**
	 * Invierte los dos valores superiores de la pila de operandos.
	 * Es decir, la cima y el valor inmediatamente debajo de esta ("subcima") se intercambian,
	 * de forma que la subcima pasa a ser la cima y viceversa.
	 * @return true si se ejecuto con exito
	 * @throws InstructionExecutionException 
	 */
	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs)
			throws InstructionExecutionException{
		int cima, subcima;
		if(os.size() > 1){
			cima = os.getCima();
			os.pop();
			subcima = os.getCima();
			os.pop();
			os.push(cima);
			os.push(subcima);
		}
		else{
			throw new InstructionExecutionException(toString(), os.size());
		}
	}

	public String toString() {
		return "FLIP";
	}

	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("FLIP") ){
			instr = new Flip();
		}
		return instr;
	}

}
