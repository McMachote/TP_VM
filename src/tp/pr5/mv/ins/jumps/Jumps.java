package tp.pr5.mv.ins.jumps;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

/*
 * Clase, no interfaz.
 * Mantiene homogeneidad con arithmetics, que tiene un atributo.
 * Asi son del mismo tipo los "niveles" de la jerarquia de clases
 */
public abstract class Jumps implements Instruction{ 
		
	public abstract Instruction parse(String s);

	public abstract void execute(Memory mem, OperandStack OS, ExecutionManager em, InStrategy ins, OutStrategy outs)
			throws InstructionExecutionException, InstructionMemoryException, DivByZero;
	
	public abstract String toString();

}
