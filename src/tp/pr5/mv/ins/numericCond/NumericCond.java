package tp.pr5.mv.ins.numericCond;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

/**
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public abstract class NumericCond implements Instruction{

	public abstract String toString();

	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs)
			throws InstructionExecutionException{
		if(os.size() > 1){
			int cima = os.getCima();
			os.pop();
			int subcima = os.getCima();
			os.pop();
			execute(cima, subcima, os);
		}
		else{
			throw new InstructionExecutionException("Error ejecutando  " + toString() + ": faltan operandos en la pila (elementos totales en ella: " + os.size() + ")");
		}
	}

	public abstract Instruction parse(String s);

	public abstract void execute(int cima, int subcima, OperandStack os); 

}
