package tp.pr5.mv.ins.jumps;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

/**
 * 
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class Jump extends Jumps {
	
	private int n;
	
	/**
	 * Default construction para el parser
	 */
	public Jump(){
		super();
	}
	
	/**
	 * Constructor con parametros
	 * @param n - longitud del salto
	 */
	public Jump(int n){
		this.n = n;
	}
	
	/**
	 * Parser
	 */
	public Instruction parse(String s){
		String[] ld = s.split(" ");
		Instruction instr = null;
		if(ld.length == 2 && ld[0].equalsIgnoreCase("JUMP")){
			try{
				int n = Integer.parseInt(ld[1]);
				if(n >= 0){
					instr = new Jump(n);
				}
			}catch(NumberFormatException nfe){
				
			}
		}
		return instr;
	}

	public void execute(Memory mem, OperandStack OS, ExecutionManager em, InStrategy ins, OutStrategy outs){
		em.jumpingJackFlash(this.n);//cpu nos incrementara pc despues de cada iteracion
	}

	public String toString() {
		return "JUMP " + this.n;
	}

}