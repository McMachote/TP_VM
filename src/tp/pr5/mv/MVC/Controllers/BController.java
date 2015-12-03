package tp.pr5.mv.MVC.Controllers;

import tp.pr5.mv.CPU;
import tp.pr5.mv.MVC.View;
import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.exceptions_mv.ProgramEnd;

public class BController implements Controller {

	private CPU cpu;
	
	public BController (CPU cpu){
		this.cpu = cpu;
	}
	
	public void run() throws InstructionExecutionException, InstructionMemoryException, DivByZero, ProgramEnd {
		this.cpu.run();
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	public void addObs(View v) {
		// TODO Auto-generated method stub
		this.cpu.addObs(v);
	}

}
