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

public class RJump extends Jumps{

	private int n;
	
	/**
	 * Default constructor.
	 */
	public RJump(){
		super();
	}
	
	public RJump(int n){
		this.n = n;
	}
	
	public Instruction parse(String s) {
		String ld[] = s.split(" ");
		Instruction instr = null;
		if(ld.length == 2 && ld[0].equalsIgnoreCase("RJUMP")){
			try{
				int num = Integer.parseInt(ld[1]);
				instr = new RJump(num);
			}catch(NumberFormatException nfe){}
		}
		return instr;
	}

	public void execute(Memory mem, OperandStack OS, ExecutionManager em, InStrategy ins, OutStrategy outs)
			throws InstructionExecutionException, InstructionMemoryException, DivByZero{
		em.jumpingJackFlash(em.getNextPc() + this.n);
	}

	public String toString() {
		return "RJUMP " + this.n;
	}

}
