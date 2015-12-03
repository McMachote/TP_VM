package tp.pr5.mv.ins.restSeq;

import java.io.File;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public class IN extends RestSec{

	File archivo;
	
	public IN(){
		this.archivo = null;
	}
	
	public String toString() {
		return "IN ";
	}

	public void execute(Memory mem, OperandStack OS, ExecutionManager em, InStrategy ins, OutStrategy outs){
		int n = ins.read();
		OS.push(n);
	}

	public Instruction parse(String s) {
		String ld[] = s.split(" ");
		Instruction instr = null;
		if(ld.length == 1 && ld[0].equalsIgnoreCase("IN")){
			instr = new IN();
		}
		return instr;
	}
	
	
	
}
