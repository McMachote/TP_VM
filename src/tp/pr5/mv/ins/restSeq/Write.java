package tp.pr5.mv.ins.restSeq;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.MemoryCell;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public class Write extends RestSec{

	private MemoryCell mc;
	
	public Write(){
		super();
	}
	
	public Write(int value, int position){
		this.mc = new MemoryCell(value, position);
	}
	
	public String toString() {
		return "WRITE " + mc.getContenido() + " " + this.mc.getPos();
	}

	public void execute(Memory mem, OperandStack OS, ExecutionManager em, InStrategy ins, OutStrategy outs){
		mem.store(mc);
	}

	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 3){
			try{
				int value = Integer.parseInt(ld[1]);
				int position = Integer.parseInt(ld[2]);
				if(position >= 0){
					instr = new Write(position, value);
				}
			}catch(NumberFormatException nfe){}
		}
		return instr;
	}

}
