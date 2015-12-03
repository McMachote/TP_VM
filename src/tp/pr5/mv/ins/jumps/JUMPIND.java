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

public class JUMPIND extends Jumps{

	public JUMPIND(){
		super();
	}
	
	public Instruction parse(String s) {
		String[] ld = s.split(" ");
		Instruction instr = null;
		if(ld.length == 1 && ld[0].equalsIgnoreCase("JUMPIND")){
			instr = new JUMPIND();
		}
		return instr;
	}

	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs)
			throws InstructionExecutionException, InstructionMemoryException, DivByZero{
		Instruction inst = null;
		if(!os.esVacia()){
			int n = os.getCima();
			os.pop();
			inst = new Jump(n);
			inst.execute(mem, os, em, ins, outs);
		}
		else{
			throw new InstructionExecutionException(toString(), os.size());
		}
	}

	public String toString() {
		return "JUMPIND ";
	}

}
