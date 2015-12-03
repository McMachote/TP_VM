package tp.pr5.mv.ins.restSeq;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public class Push extends RestSec{

	private int n;
	
	public Push(){
		super();
	}
	
	/**
	 * Constructor de instrucciones de dos operandos
	 */
	public Push(int n){
		super();
		this.n = n;
	}

	/**
	 * Apila en la pila de operandos el entero n de la instruccion.
	 * @param n - Entero a introducir en la pila
	 * @return true si se ejecuto con exito
	 */
	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs){
		os.push(this.n);
	}

	public String toString() {
		return "PUSH " + this.n;
	}

	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 2 && ld[0].equalsIgnoreCase("PUSH") ){
			try{
				int n = Integer.parseInt(ld[1]);
				instr = new Push(n);
			}catch(NumberFormatException nfe){
				
			}
		}
		return instr;
	}

}
