package tp.pr5.mv.ins.arithmetics;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

/**
 * Clase padre de las operaciones aritmeticas.
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor.
 */
public abstract class Arithmetics implements Instruction{
	
	/**
	 * Ejecutar.
	 * @throws InstructionExecutionException 
	 * @throws DivByZero 
	 */
	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs)
	throws InstructionExecutionException, DivByZero{
		if(os.size() > 1){
			int cima = os.getCima();
			os.pop();
			int subcima = os.getCima();
			os.pop();
			try {
				execute(cima, subcima, os);
			} catch (DivByZero dz) {
				os.push(subcima);
				os.push(cima);
				//System.err.println(dz.getMessage());//printea cpu!!
				//if(ins.getName().equalsIgnoreCase("WINDOWINSTRATEGY")
				//		&& outs.getName().equalsIgnoreCase("WINDOWOUTSTRATEGY")){
					throw new DivByZero();
				//}
			}
		}
		else{
			throw new InstructionExecutionException(toString(), os.size());
		}
	}
	
	public abstract void execute(int cima, int subcima, OperandStack os) throws DivByZero;
	
	/**
	 * Parser.
	 */
	public abstract Instruction parse(String s);

	/**
	 * Redefinir toString().
	 */
	public abstract String toString();
	
}
