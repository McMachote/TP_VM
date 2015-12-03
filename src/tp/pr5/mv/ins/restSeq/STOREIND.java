package tp.pr5.mv.ins.restSeq;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public class STOREIND extends RestSec{

	public STOREIND(){
		super();
	}
	
	public String toString() {
		return "STOREIND ";
	}

	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs)
			throws InstructionExecutionException, InstructionMemoryException, DivByZero {
		if(os.size() > 1){
			int n = os.getCima();
			os.pop();
			int pos = os.getCima();
			if(pos < 0){
				os.push(pos);
				os.push(n);
				throw new InstructionMemoryException(toString(), pos);
			}
			os.push(n);
			Instruction instr = new Store(pos);
			instr.execute(mem, os, em, ins, outs);
		}
		else{
			throw new InstructionExecutionException(toString(), os.size());
		}
	}

	public Instruction parse(String s) {
		String[] ld = s.split(" ");
		Instruction instr = null;
		if(ld.length == 1 && ld[0].equalsIgnoreCase("STOREIND")){
			instr = new STOREIND();
		}
		return instr;
	}

}
