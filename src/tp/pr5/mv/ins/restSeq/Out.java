package tp.pr5.mv.ins.restSeq;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public class Out extends RestSec{
	
	/**
	 * Default constructor
	 */
	public Out(){
		super();
	}

	/**
	 * Escribe el caracter almacenado en la cima de la pila.
	 * Dado que en la pila de operandos lo que se manejan son enteros, debera primero convertirlo
	 * al tipo caracter.
	 * La operación tendrá un comportamiento indeterminado si el entero no es un caracter valido.
	 * @return true si se ejecuto con exito
	 * @throws InstructionExecutionException 
	 */
	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs)
			throws InstructionExecutionException{
		if(os.size() > 0){
			int n = os.getCima();
			os.pop();
			outs.write((char) n);
		}
		else{
			throw new InstructionExecutionException("Error ejecutando  OUT: faltan operandos en la pila (elementos totales en ella: 0)");
		}
	}

	public String toString() {
		return "OUT";
	}

	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("OUT") ){
			instr = new Out();
		}
		return instr;
	}
	
}
