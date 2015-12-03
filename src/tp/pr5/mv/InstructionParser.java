package tp.pr5.mv;

import tp.pr5.mv.exceptions_mv.ASM_Exception;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.ins.arithmetics.*;
import tp.pr5.mv.ins.booleanCond.*;
import tp.pr5.mv.ins.jumps.*;
import tp.pr5.mv.ins.numericCond.*;
import tp.pr5.mv.ins.restSeq.*;

/**
 * Es la clase encargada de parsear un string que contiene una posible instruccion.
 * Concretamente dispone de un metodo Instruction parse(String s) que devuelve
 * la instruccion almacenada en s o bien null si s no representa ninguna instruccion de las permitidas.
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class InstructionParser {

	/**
	 * Default constructor.
	 */
	public InstructionParser(){}
	
	/**
	 * Array de instrucciones con el que comparar
	 */
	private static final Instruction[] instructions = {
		//Arithmetics
		new Add(), new Sub(), new Mul(), new Div(),
		//BooleanCond
		new And(), new Not(), new Or(),
		//Jumps
		new BF(), new BT(), new Jump(),
		//Relative Jumps
		new RJump(), new RBF(), new RBT(),
		//NumericCond
		new EQ(), new GT(),	new LE(), new LT(),
		//RestSeq
		new Dup(), new Flip(), new Halt(), new Load(),
		//new Neg(), 
		new Out(), new Pop(), new Push(), new Store(),
		//P3--En restSec
		new IN(), new LOADIND(), new STOREIND(),
		//P3--En jumps
		new JUMPIND()
	};

	/**
	 * Parser de instrucciones
	 * @param s - string a parsear
	 * @return Insstruction si encuentra, null si no
	 * @throws ASM_Exception 
	 */
	public static Instruction parse(String s , String mode)
	throws ASM_Exception{
		String cad = "";
		int endIndex = -1;
		boolean stop = false;
		int i = 0;
		Instruction instr = null;
		while (i < instructions.length && !stop){
			endIndex = s.indexOf(';');
			if(endIndex != -1){
				cad = s.substring(0, endIndex);
			}
			else{
				cad = s;
			}
			instr = instructions[i].parse(cad);
			if (instr != null)
				stop = true;
			else
				i++;
		}
		if((instr == null && !cad.equalsIgnoreCase("")) && !s.equalsIgnoreCase("END")){
			if(mode.equalsIgnoreCase("batch")) throw new ASM_Exception(s);
		}
		return instr;
	}
	
}
