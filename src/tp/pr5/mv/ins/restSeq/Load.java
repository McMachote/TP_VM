package tp.pr5.mv.ins.restSeq;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.MemoryCell;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public class Load extends RestSec{
	
	private int pos;
	
	public Load(){
		super();
	}
	
	/**
	 * Constructor de instrucciones de dos operandos
	 * @param n
	 */
	public Load(int n){
		super();
		this.pos = n;
	}

	/**
	 * Lee de memoria el valor almacenado en pos y lo apila en la pila de operandos.
	 * @param posicion
	 * @return true si se ejecuto con exito
	 * @throws InstructionMemoryException 
	 */
	public void execute(Memory mem, OperandStack OS, ExecutionManager em, InStrategy ins, OutStrategy outs)
	throws InstructionMemoryException{
		MemoryCell mc = mem.load(pos);
		if(pos >= 0){
			if(mc != null){
				OS.push(mc.getContenido());
			}
		}
		else{
			throw new InstructionMemoryException(this.toString(), this.pos);
		}
	}

	public String toString() {
		return "LOAD " + this.pos;
	}

	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 2 && ld[0].equalsIgnoreCase("LOAD") ){
			try{
				int n = Integer.parseInt(ld[1]);
				instr = new Load(n);
			}catch(NumberFormatException nfe){}
		}
		return instr;
	}

}
