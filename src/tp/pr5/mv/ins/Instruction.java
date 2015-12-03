package tp.pr5.mv.ins;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

/**
 * Implementa las distintas instrucciones que puede manejar nuestra maquina virtual.
 * Para representar las distintas instrucciones utiliza un tipo enumerado
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public abstract interface Instruction {
	
	/**
	 * Obligara a redefinir el toString().
	 * @return String - nombre de la instruccion.
	 */
	public abstract String toString();
	
	/**
	 * Parser.
	 * @param s - String a parsear.
	 * @return Instruction contenida en s o null si s no contiene ninguna instruccion valida.
	 * @throws InstructionMemoryException 
	 */
	public abstract Instruction parse(String s);// throws InstructionMemoryException;
	
	/**
	 * Ejecutar.
	 * @param ins TODO
	 * @param outs TODO
	 * @param cpu
	 * @return boolean - true si se ha ejecutado con exito.
	 * @throws InstructionExecutionException 
	 * @throws InstructionMemoryException 
	 * @throws DivByZero 
	 */
	public abstract void execute(Memory mem, OperandStack OS, ExecutionManager em,
			InStrategy ins, OutStrategy outs) throws InstructionExecutionException, InstructionMemoryException, DivByZero;
}
