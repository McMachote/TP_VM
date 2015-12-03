package tp.pr5.mv.ins.restSeq;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public class Halt extends RestSec{

	/**
	 * Default constructor
	 */
	public Halt(){
		super();
	}
	
	/**
	 * Para la maquina.
	 * @return true - Siempre se deberia ejecutar con exito
	 */
	public void execute(Memory mem, OperandStack OS, ExecutionManager em,
						InStrategy ins, OutStrategy outs){
		em.stop();
	}

	public String toString() {
		return "HALT";
	}

	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 1 && ld[0].equalsIgnoreCase("HALT") ){
			instr = new Halt();
		}
		return instr;
	}

}
