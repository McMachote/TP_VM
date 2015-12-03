package tp.pr5.mv.ins.arithmetics;

import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ins.Instruction;

/**
 * Instruccion resta.
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor.
 */
public class Sub extends Arithmetics{

	/**
	 * Default constructor
	 */
	public Sub() {
		super();
	}

	/**
	 * Redefine toString().
	 */
	public String toString(){
		return "SUB";
	}

	/**
	 * Parser.
	 */
	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("SUB") ){
			instr = new Sub();
		}
		return instr;
	}

	/**
	 * Ejecutar.
	 * @param int n1 - Cima de la pila de operandos.
	 * @param int n2 - Subcima de la pila de operandos.
	 * @return n1-n2;
	 */
	public void execute(int cima, int subcima, OperandStack os) {
		os.push(subcima - cima);
	}
	
}
