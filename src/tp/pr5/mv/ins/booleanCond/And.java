package tp.pr5.mv.ins.booleanCond;

import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.ins.Instruction;

public class And extends BooleanCond{

	/**
	 * Default constructor.
	 */
	public And(){
		super();
	}

	public String toString() {
		return "AND";
	}

	/**
	 * Parser.
	 */
	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("AND")){
			instr = new And();
		}
		return instr;
	}

	public void execute(int a, int b, OperandStack os)
			throws InstructionExecutionException {
		if(a != 0 && b != 0){
			os.push(1);
		}
		else{
			os.push(0);
		}
	}

}
