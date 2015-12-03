package tp.pr5.mv.ins.arithmetics;

import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ins.Instruction;

/**
 * Instruccion multiplicar.
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor.
 */
public class Mul extends Arithmetics{
	
	/**
	 * Default constructor.
	 */
	public Mul() {
		super();
	}
	
	/**
	 * Parser.
	 */
	public Instruction parse(String s){
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("MUL") ){
				instr = new Mul();
		}
		return instr;
	}
	
	/**
	 * Redefine toString().
	 */
	public String toString() {
		return "MUL";
	}

	/**
	 * Ejecutar.
	 * @param int n1 - Cima de la pila de operandos.
	 * @param int n2 - Subcima de la pila de operandos.
	 * @return
	 */
	public void execute(int cima, int subcima, OperandStack os) {
		os.push(cima * subcima);
	}

}
