package tp.pr5.mv.ins.restSeq;

import tp.pr5.mv.ExecutionManager;
import tp.pr5.mv.Memory;
import tp.pr5.mv.MemoryCell;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

public class Store extends RestSec{
	
	private int pos;

	public Store(){
		super();
	}
	
	/**
	 * Constructor de operaciones de dos operandos
	 * @param n
	 */
	public Store(int n){
		super();
		this.pos = n;
	}

	/**
	 * Escribe en la posicion pos de memoria el contenido de la cima de la pila de operandos,
	 * que se elimina.
	 * @param pos - Determina la posicion de memoria que ocupara el contenido de la cima
	 * @return true si se ejecuto con exito
	 * @throws InstructionMemoryException 
	 * @throws InstructionExecutionException 
	 */
	public void execute(Memory mem, OperandStack os, ExecutionManager em, InStrategy ins, OutStrategy outs)
			throws InstructionMemoryException, InstructionExecutionException{
		if(pos >= 0){
			Integer dato = os.getCima();
			MemoryCell mc = new MemoryCell(dato, pos);
			mem.store(mc);
			os.pop();
		}
		else{
			throw new InstructionMemoryException(toString(), os.size());
		}
	}

	public String toString() {
		return "STORE " + this.pos;
	}

	public Instruction parse(String s) {
		Instruction instr = null;
		String[] ld = s.split(" ");
		if(ld.length == 2 && ld[0].equalsIgnoreCase("STORE") ){
			try{
				int n = Integer.parseInt(ld[1]);
				instr = new Store(n);
			}catch(NumberFormatException nfe){}
		}
		return instr;
	}

}
