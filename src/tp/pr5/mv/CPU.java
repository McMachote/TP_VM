package tp.pr5.mv;

import java.util.ArrayList;

import tp.pr5.mv.MVC.View;
import tp.pr5.mv.MVC.IObservers.InObserver;
import tp.pr5.mv.MVC.IObservers.MemoryObserver;
import tp.pr5.mv.MVC.IObservers.OutObserver;
import tp.pr5.mv.MVC.IObservers.ProgramObserver;
import tp.pr5.mv.MVC.IObservers.StackObserver;
import tp.pr5.mv.comm.CommandInterpreter;
import tp.pr5.mv.comm.Run;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategys.instrategys.InStrategy;
import tp.pr5.mv.strategys.outstrategys.OutStrategy;

/**
 * Es la unidad de procesamiento de nuestra maquina virtual.
 * Contiene una memoria, una pila de operandos y una varible booleana para determinar si la
 * ejecucion ha terminado, es decir, si se ha ejecutado la instruccion HALT.
 * @author Rayner Tan Luc & Juan Miguel Lacruz Camblor
 */
public class CPU {
	
	private Memory mem;
	private OperandStack os;
	private ProgramMV pmv;
	private ExecutionManager em;
	private InStrategy ins;
	private OutStrategy outs;
	private ArrayList<View> vistas;
	
	/**
	 * Default constructor
	 */
	public CPU (){
		this.mem    = new Memory();
		this.os     = new OperandStack();
		this.pmv    = new ProgramMV();
		this.em     = new ExecutionManager();
		this.ins    = null;
		this.outs   = null;
		this.vistas = new ArrayList<View>();
	}
	
	/**
	 * Redefine el metodo toString()
	 * @return string - Estado de la cpu, OperandStack y Memory
	 */
	public String toString(){
		String s = "";
		s += Constants.STATE + Constants.LS;
		s += this.mem.toString();
		s += this.os.toString();
		return s;
	}
	
	public String stackString(){
		return this.os.toWindowString();
	}
	
	public String memoryString(){
		return this.mem.toWindowString();
	}
        
    /**
     * Permite cargar un programa.
     * @param pmv ProgramMV - Instrucciones a ejecutar almacenadas.
     */
    public void loadProgram (ProgramMV pmv){
    	this.pmv = pmv;
    	int n = this.pmv.size();
    	this.em = new ExecutionManager(n);
    }
    
    public void loadStrategys(InStrategy ins, OutStrategy outs){
    	this.ins  = ins;
    	this.outs = outs;
    }
    
    /**
     * Ejecuta la siguiente instruccion, devolviendo false si hay algun error.
     * Se encargara tambien de gestionar el contador de programa, para que la siguiente
     * invocacion a step() ejecute la instruccioon de la tpmv o la instruccioon a la que se salto.
     * @return
     * @throws InstructionExecutionException 
     * @throws InstructionMemoryException 
     * @throws DivByZero 
     */
    public boolean step() throws InstructionExecutionException, InstructionMemoryException, DivByZero {
    	Instruction instr = null;
    	boolean check = false;
    	int i = this.em.getNextPc();
    	if(i >= 0 && i < pmv.size()){
    		instr = pmv.get(i);
    		instr.execute(this.mem, this.os, this.em, this.ins, this.outs);
    		check = true;
			if(check){
				this.em.incrementPc();
				for(View v : this.vistas){
					v.showStatus(Constants.CURRENT_EXE + instr + Constants.LS + this);
				}
			}
			if(this.em.isHalted()){
				check = false;
			}
    	}
    	else{
    		this.em.stop();
    	}
    	return check;
    }

    /**
     * Step especial para comandos, no hace correr nextpc
     * @param instr
     * @return true - si y solo si se ha ejecutado con exito
     * @throws InstructionExecutionException 
     * @throws InstructionMemoryException 
     * @throws DivByZero 
     */
    public boolean step(Instruction instr) throws InstructionExecutionException, InstructionMemoryException, DivByZero{
    	boolean check = false;
		instr.execute(this.mem, this.os, this.em, ins, outs);
		check = true;
    	return check;
    }
    
    /**
	 * Chequea si se ha apagado la CPU
	 * @return true - si y solo si se ha parado
	 */
	public boolean isHalted(){
		return this.em.isHalted();
	}

	public ProgramMV getWindowProgram() {
		return this.pmv;
	}

	public int ShowPC(){
		return this.em.getNextPc();
	}

	public void run() throws InstructionExecutionException, InstructionMemoryException, DivByZero {
		CommandInterpreter.configureCommandInterpreter(this);
		Run runnigWithTheDevil = new Run();
		runnigWithTheDevil.executeCommand();
	}
	
	public String getOutput(){
		return this.outs.toString();
	}
	
	public String getInput(){
		return this.ins.toString();
	}
	
	public void addObs(View v){
		this.vistas.add(v);
	}

	public void addObsStack(StackObserver obs) {
		// TODO Auto-generated method stub
		this.os.addObs(obs);
	}

	public void addObsMemory(MemoryObserver memoryObs) {
		// TODO Auto-generated method stub
		this.mem.addObs(memoryObs);
	}
	
	public void addObsProgram(ProgramObserver obs){
		this.em.addObs(obs);
	}

	public void addObsIns(InObserver inObs) {
		// TODO Auto-generated method stub
		this.ins.addObs(inObs);
	}

	public void addObsOuts(OutObserver outObs) {
		// TODO Auto-generated method stub
		this.outs.addObs(outObs);
	}
	
}
