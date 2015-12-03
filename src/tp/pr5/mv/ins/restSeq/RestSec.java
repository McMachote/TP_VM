package tp.pr5.mv.ins.restSeq;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public abstract class RestSec implements Instruction {

	public abstract String toString();

	public abstract void execute(Memory mem, OperandStack OS, ExecutionManager em, InStrategy ins, OutStrategy outs)
	throws InstructionExecutionException, InstructionMemoryException, DivByZero;
	
	public abstract Instruction parse(String s);

}
