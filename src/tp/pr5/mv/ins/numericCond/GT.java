package tp.pr5.mv.ins.numericCond;

import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ins.Instruction;

/**
 * 
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class GT extends NumericCond{

	/**
	 * Default constructor.
	 */
	public GT(){
		super();
	}
	
	/**
	 * Sobreescritura toString()
	 */
	public String toString() {
		return "GT";
	}

	/**
	 * Parser.
	 */
	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("GT")){
			instr = new GT();
		}
		return instr;
	}

	public void execute(int cima, int subcima, OperandStack os) {
		if(subcima > cima){
			os.push(1);
		}
		else{
			os.push(0);
		}
	}

}
