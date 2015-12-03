package tp.pr5.mv.ins.numericCond;

import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ins.Instruction;

/**
 * 
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class LT extends NumericCond{

	/**
	 * Default constructor.
	 */
	public LT(){
		super();
	}
	
	/**
	 * Sobreescritura toString()
	 */
	@Override
	public String toString() {
		return "LT";
	}

	/**
	 * Parser.
	 */
	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("LT")){
			instr = new LT();
		}
		return instr;
	}

	public void execute(int cima, int subcima, OperandStack os) {
		if(subcima < cima){
			os.push(1);
		}
		else{
			os.push(0);
		}
	}

}
