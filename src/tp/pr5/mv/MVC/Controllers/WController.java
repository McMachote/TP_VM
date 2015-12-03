package tp.pr5.mv.MVC.Controllers;

import tp.pr5.mv.CPU;
import tp.pr5.mv.MVC.IObservers.InObserver;
import tp.pr5.mv.MVC.IObservers.MemoryObserver;
import tp.pr5.mv.MVC.IObservers.OutObserver;
import tp.pr5.mv.MVC.IObservers.ProgramObserver;
import tp.pr5.mv.MVC.IObservers.StackObserver;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.exceptions_mv.ProgramEnd;
import tp.pr5.mv.ins.restSeq.Pop;
import tp.pr5.mv.ins.restSeq.Push;
import tp.pr5.mv.ins.restSeq.Write;

public class WController implements Controller {

	private CPU cpu;

	public WController(CPU cpu){
		this.cpu = cpu;
	}

	public void step() throws InstructionExecutionException, InstructionMemoryException, DivByZero, ProgramEnd {
		if(!this.cpu.isHalted()){
			this.cpu.step();
		}
		else{
			throw new ProgramEnd();
		}
	}
	
	public void pop() throws InstructionExecutionException, InstructionMemoryException, DivByZero{
		Pop p = new Pop();
		this.cpu.step(p);
	}
	
	public void push(int n) throws InstructionExecutionException, InstructionMemoryException, DivByZero{
		Push p = new Push(n);
		this.cpu.step(p);
	}

	public void write(int value, int pos) throws InstructionExecutionException, InstructionMemoryException, DivByZero{
		Write w = new Write(value, pos);
		this.cpu.step(w);
	}
	
	public void quit(){//no utilizado!!
		System.exit(0);
	}

	@Override
	public void run() throws InstructionExecutionException,
			InstructionMemoryException, DivByZero, ProgramEnd {
		// TODO Auto-generated method stub
		if(!this.cpu.isHalted()){
			this.cpu.run();
		}
		else{
			throw new ProgramEnd();
		}
	}
	
	public String getProgram(){
		return this.cpu.getWindowProgram().toString();
	}
	
	public int getPc(){
		return this.cpu.ShowPC();
	}

	public void addObsStack(StackObserver obs) {
		// TODO Auto-generated method stub
		this.cpu.addObsStack(obs);
	}
	
	public void addObsMemory(MemoryObserver memoryPanel) {
		// TODO Auto-generated method stub
		this.cpu.addObsMemory(memoryPanel);
	}

	public void addObsProgram(ProgramObserver programObs) {
		// TODO Auto-generated method stub
		this.cpu.addObsProgram(programObs);
	}

	public void addObsInS(InObserver inObs) {
		// TODO Auto-generated method stub
		this.cpu.addObsIns(inObs);
	}
	
	public void addObsOutS(OutObserver outObs) {
		// TODO Auto-generated method stub
		this.cpu.addObsOuts(outObs);
	}

	public String stackString() {
		// TODO Auto-generated method stub
		return this.cpu.stackString();
	}

	public String memoryString() {
		// TODO Auto-generated method stub
		return this.cpu.memoryString();
	}

	public String getInput() {
		// TODO Auto-generated method stub
		return this.cpu.getInput();
	}
	
	public String getOutput(){
		return this.cpu.getOutput();
	}

	public boolean shouldKeepGoing() {
		// TODO Auto-generated method stub
		return !this.cpu.isHalted();
	}
	
}
