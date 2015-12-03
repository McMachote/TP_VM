package tp.pr5.mv.ins.arithmetics;

import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ins.Instruction;

/**
 * Instruccion suma.
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor.
 */
public class Add extends Arithmetics{
	
	/**
	 * Default constructor.
	 */
	public Add() {
		super();
	}

	/**
	 * Ejecutar suma.
	 * @return cima + subcima
	 */
	public void execute(int cima, int subcima, OperandStack os){
		os.push(cima + subcima);
	}

	/**
	 * Parser.
	 */
	public Instruction parse(String s){
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("ADD") ){
			instr = new Add();
		}
		return instr;
	}
	
	/**
	 * Redefinicion toString().
	 */
	public String toString(){
		return "ADD";
	}
	
}
