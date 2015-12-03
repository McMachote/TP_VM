package tp.pr5.mv.ins.arithmetics;

import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.ins.Instruction;

/**
 * Instruccion dividir.
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor.
 */
public class Div extends Arithmetics{

	/**
	 * Default constructor.
	 */
	public Div() {
		super();
	}

	/**
	 * Parser.
	 */
	public Instruction parse(String s){
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("DIV") ){
			instr = new Div();
		}
		return instr;
	}
	
	/**
	 * Redefinicion de toString().
	 */
	public String toString(){
		return "DIV";
	}

	/**
	 * DIVISION
	 * @return true si se ejecuto con exito
	 * @throws DivByZero 
	 */
	public void execute(int cima, int subcima, OperandStack os) throws DivByZero{
		if(cima != 0){
		int n = subcima/cima;
		os.push(n);
		}
		else{
			throw new DivByZero();
		}
	}
	
}
