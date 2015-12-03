package tp.pr5.mv.MVC.Controllers;

import tp.pr5.mv.exceptions_mv.DivByZero;
import tp.pr5.mv.exceptions_mv.InstructionExecutionException;
import tp.pr5.mv.exceptions_mv.InstructionMemoryException;
import tp.pr5.mv.exceptions_mv.ProgramEnd;

public interface Controller {

	public void run()  throws InstructionExecutionException, InstructionMemoryException, DivByZero, ProgramEnd ;
	public void quit();
	
}
