package tp.pr5.mv.ins.restSeq;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public class LOADIND extends RestSec{

	private int n;
	
	public LOADIND(){
		super();
	}
	
	public String toString() {
		return "LOADIND ";
	}

	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs)
	throws InstructionExecutionException, InstructionMemoryException {
		if(!os.esVacia()){
			this.n = os.getCima();
			Load ld = new Load(this.n);
			ld.execute(mem, os, em, null, null);
		}
		else{
			throw new InstructionExecutionException(toString(), os.size());
		}
	}

	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("LOADIND") ){
			instr = new LOADIND();
		}
		return instr;
	}

	
	
}
