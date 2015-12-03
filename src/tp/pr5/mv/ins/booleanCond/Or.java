package tp.pr5.mv.ins.booleanCond;

import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.ins.Instruction;

public class Or extends BooleanCond{

	/**
	 * Default constructor.
	 */
	public Or(){
		super();
	}

	public String toString() {
		return "OR";
	}

	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("OR")){
			instr = new Or();
		}
		return instr;
	}

	public void execute(int a, int b, OperandStack os)
			throws InstructionExecutionException {
		if(a == 0 && b == 0){
			os.push(0);
		}
		else{
			os.push(1);
		}
	}
	
}
