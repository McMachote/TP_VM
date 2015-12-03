package tp.pr5.mv.ins.booleanCond;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public class Not extends BooleanCond{

	/**
	 * Default constructor.
	 */
	public Not (){
		super();
	}

	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs)
			throws InstructionExecutionException{
		if(os.size() >= 1){
			int a = os.getCima();
			os.pop();
			execute(a, 0, os);
		}
		else{
			throw new InstructionExecutionException(toString(), os.size());
		}
	}

	public String toString() {
		return "NOT";
	}

	/**
	 * Parser.
	 */
	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("NOT")){
			instr = new Not();
		}
		return instr;
	}

	public void execute(int a, int nulidaddelavida, OperandStack os){
		if(a == 0){
			os.push(1);
		}
		else{
			os.push(0);
		}
	}

}
