package tp.pr5.mv.ins.restSeq;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public class Neg extends RestSec{

	public Neg(){
		super();
	}
	
	public String toString() {
		return "NEG";
	}

	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs) throws InstructionExecutionException{
		if(os.size() > 0){
			int a = os.getCima();
			os.pop();
			os.push(-a);
		}
	}

	public Instruction parse(String s) {
		String ld[] = s.split(" ");
		Instruction instr = null;
		if(ld.length == 1 && ld[0].equalsIgnoreCase("NEG")){
			instr = new Neg();
		}
		return instr;
	}

}
