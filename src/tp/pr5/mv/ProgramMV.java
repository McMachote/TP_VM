package tp.pr5.mv;

import java.util.ArrayList;

import tp.pr5.mv.ins.Instruction;

/**
 * Clase que representa un programa.
 * Por lo tanto contendra la secuencia completa de instrucciones de las que consta el programa.
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class ProgramMV extends ArrayList <Instruction>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public ProgramMV(){
		super();
	}
	
	/**
	 * Redefinicion metodo toString()
	 */
	public String toString(){
		String s = "";
		if(!this.isEmpty()){
			for(int i = 0; i < this.size(); i++){
				s +=  i + ": " + this.get(i).toString() + Constants.LS;
			}
		}
		return s;
	}

	/**
	 * Annade una instruccion al programa
	 * @param instr - Instruction a annadir
	 */
	public void addInstruction(Instruction instr){
		this.add(instr);
	}
	
}
