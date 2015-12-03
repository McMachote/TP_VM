package tp.pr5.mv.ins.numericCond;

import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ins.Instruction;

/**
 * 
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class EQ extends NumericCond{

	/**
	 * Default constructor.
	 */
	public EQ(){
		super();
	}
	
	/**
	 * Sobreescritura toString()
	 */
	public String toString() {
		return "EQ";
	}

	/**
	 * Parser.
	 */
	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("EQ")){
			instr = new EQ();
		}
		return instr;
	}

	public void execute(int cima, int subcima, OperandStack os) {
		if(subcima == cima){
			os.push(1);
		}
		else{
			os.push(0);
		}
	}

}
