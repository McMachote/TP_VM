package tp.pr5.mv.ins.jumps;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

/**
 * 
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class BT extends Jumps{
	
	private int n;
	
	/**
	 * Constructor por defecto
	 */
	public BT(){
		super();
	}
	
	/**
	 * Constructor con parametros
	 * @param n
	 */
	public BT(int n){
		this.n = n;
	}
	
	/**
	 * Parser
	 */
	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 2 && ld[0].equalsIgnoreCase("BT")){
			try{
				int n = Integer.parseInt(ld[1]);
				instr = new BT(n);
			}catch(NumberFormatException nfe){}
		}
		return instr;
	}

	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs)
			throws InstructionExecutionException{
		if(os.size() > 0){
			int a = os.getCima();
			os.pop();
			if(a != 0){
				em.jumpingJackFlash(this.n);
			}
		}
	}

	/**
	 * Sobreescritura del metodo toString()
	 */
	public String toString() {
		return "BT " + this.n;
	}

}
