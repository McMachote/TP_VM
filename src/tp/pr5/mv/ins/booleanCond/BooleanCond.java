package tp.pr5.mv.ins.booleanCond;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public abstract class BooleanCond implements Instruction{

	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs)
	throws InstructionExecutionException {
		if(os.size() > 1){
			int a = os.getCima();
			os.pop();
			int b = os.getCima();
			os.pop();
			execute(a, b, os);
		}
		else{
			throw new InstructionExecutionException(toString(), os.size());
		}
	}

	public abstract void execute(int cima, int subcima, OperandStack os) throws InstructionExecutionException;

	public abstract String toString();

	public abstract Instruction parse(String s);

}
